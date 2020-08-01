package com.bruteforce.taxapplication.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.UUID;

//@Entity
//@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue
    public String id;

    @Column(name = "datasource_id")
    public UUID dataSourceId;


}
