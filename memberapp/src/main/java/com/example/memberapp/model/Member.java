package com.example.memberapp.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.jdo.annotations.Unique;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="tbl_member")
@ToString
public class Member extends AbstractEntityModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private String passwordConfirm;
    @Unique
    private String email;
    @Column(name="role_name")
    @Enumerated(EnumType.STRING)
    private MemberRole role;



}
