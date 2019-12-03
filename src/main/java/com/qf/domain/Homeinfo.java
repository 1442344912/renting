package com.qf.domain;

import lombok.Data;


import javax.persistence.*;

@Data
@Table(name = "homeinfo")
@Entity
public class Homeinfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String picture;
    private String address;

    private String hoststyle;
    private String price;

    private String description;

    private String beiyong2;

    private String beiyong3;

    private  String cname;
}
