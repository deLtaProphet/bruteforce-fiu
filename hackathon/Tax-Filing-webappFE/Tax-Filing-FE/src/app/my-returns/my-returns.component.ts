import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-my-returns',
  templateUrl: './my-returns.component.html',
  styleUrls: ['./my-returns.component.css']
})
export class MyReturnsComponent implements OnInit {


  text = "'a&nbsp;&nbsp;b'";
  //other_income=9000;
  HRA=Number(sessionStorage.getItem('hra'));
  Gross_salary=Number(sessionStorage.getItem('Gsal'));
  other_income=Number(sessionStorage.getItem('AddIncome'));
  MF=Number(sessionStorage.getItem('MF'));
  LI=Number(sessionStorage.getItem('FD'));
  NPS=Number(sessionStorage.getItem('NPS'));
  PPF=Number(sessionStorage.getItem('PPF'));
  EPF=Number(sessionStorage.getItem('EPF'));
  //LI=Number(sessionStorage.getItem('FD'));


  /*
  MF', name: 'Mutual Fund' },
    { id: 'FD', name: 'Tax Save FD' },
    { id: 'LI', name: 'Life Insurance' },
    { id: 'NPS', name: 'National Pension Scheme' },
    { id: 'PPF', name: 'Personal Provident Fund' },
    { id: 'EPF'
  */
  constructor() { }

  ngOnInit(): void {
  }

}
