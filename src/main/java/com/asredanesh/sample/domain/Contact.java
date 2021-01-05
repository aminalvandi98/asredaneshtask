package com.asredanesh.sample.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "CONTACTS")
public class Contact implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true,nullable = false)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(unique = true,nullable = false)
    private String phoneNumber;
    private String email;
    private String organization;
    private String github;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "CONTACT_ID")
    private List<Github> githubList;
}
