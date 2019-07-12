package com.p2p.job.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Entity
@ToString
@Table(name = "tbl_members")
public class Member {

    @Id
    private String uid;
    private String upw;
    private String uname;
    


}