package com.bruteforce.taxapplication.model;

import javax.persistence.*;
import java.util.UUID;
//
//@Entity
//@Table(name = "finances")
public class Finances {

    @Id
    @GeneratedValue
    public UUID id;

    @org.hibernate.annotations.Type(type = "jsonb")
    @Column(name = "schemes", columnDefinition = "jsonb")
    public String schemes;

}

