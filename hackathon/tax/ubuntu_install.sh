#!/bin/sh
echo
echo '[#] Starting ubuntu_install.sh'

VERSION=`cat /etc/os-release | grep UBUNTU_CODENAME | awk -F '=' '{print $2}'`
echo "[i] Ubuntu version: $VERSION detected"

echo '[i] Configuring apt'
if [ "$VERSION" == "bionic" ]; then
  apt-get --assume-yes -q install software-properties-common > /var/log/ubuntu_install.log 2>&1
  apt-add-repository ppa:ansible/ansible -y >> /var/log/ubuntu_install.log 2>&1
fi 

echo '[i] Updating repositories'
apt-get --assume-yes -q update >> /var/log/ubuntu_install.log 2>&1

echo '[i] Updating installed software'
apt-get --assume-yes -q upgrade >> /var/log/ubuntu_install.log 2>&1

echo '[i] Installing supporting software'
apt-get --assume-yes -q install ansible python-pip python-apt git >> /var/log/ubuntu_install.log 2>&1
[ "$VERSION" == "bionic" ] && apt-get --assume-yes -q install ansible python-pip python-apt git >> /var/log/ubuntu_install.log 2>&1
[ "$VERSION" == "focal" ] && apt-get --assume-yes -q install ansible python3-pip python-apt git  >> /var/log/ubuntu_install.log 2>&1

echo '[i] Running ansible (this may take awhile)'
if [ ! -d "/etc/ansible" ]; then
  echo [%] Error: ansible not installed properly, check /var/log/ubuntu_install.log and rerun.
  echo
  exit 1
fi

wget -q -O /etc/ansible/github.key "https://mdm.uptycs.com/files/f/e4da1c1c93f84fba9ffc/?dl=1" >> /var/log/ubuntu_install.log 2>&1
chmod 400 /etc/ansible/github.key >> /var/log/ubuntu_install.log 2>&1

ansible-pull -U git@github.com:Uptycs/it-support-ansible-workstation-linux.git --private-key /etc/ansible/github.key -d /root/.ansible/ansible-workstation-linux --accept-host-key >> /var/log/ubuntu_install.log 2>&1

echo '[i] Configuring auto-updates'
echo 'APT::Periodic::Update-Package-Lists "1";' > /etc/apt/apt.conf.d/20auto-upgrades
echo 'APT::Periodic::Unattended-Upgrade "1";' >> /etc/apt/apt.conf.d/20auto-upgrades

echo '[i] Cleaning up'
apt-get --assume-yes -q autoremove >> /var/log/ubuntu_install.log 2>&1

echo '[#] Finished ubuntu_install.sh'
echo