package com.scm.scm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "user")
@Data
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long userId;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(length = 1000)
    private String about;

    @Column(length = 1000)
    private String profilePic;
    private  String phoneNumber;

    private boolean enabled = false;
    private boolean emailVerified = false;
    private boolean phoneVerified = false;


    @Enumerated(EnumType.STRING)
    @Column(name = "provider")
    private Providers provider = Providers.SELF;


    private String providerUserId;

    @JsonIgnore
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch =FetchType.LAZY,orphanRemoval = true)
    private List<Contact>contacts=new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    private List<SocialLink> links=new ArrayList<>();
}
