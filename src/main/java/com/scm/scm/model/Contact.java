package com.scm.scm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "contact") // Specify table name if different from class name
@Data
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(length = 20)
    private String phoneNumber;

    @Column(length = 255)
    private String address;

    @Column(length = 255)
    private String picture;

    @Column(length = 10000)
    private String description;

    private boolean favourite = false;

    @Column(length = 255)
    private String instagramLink;

    @Column(length = 255)
    private String facebookLink;

    @JsonIgnore
    @OneToMany(mappedBy = "contact",cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
    private List<SocialLink> links=new ArrayList<>();
    @ManyToOne
    private  User user;
}
