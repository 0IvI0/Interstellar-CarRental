package com.interstellarcarrental.carrental.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@Table(name = "ROLES")
public class Role {

    @Column(name = "ROLE_PRIM_KEY")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "ROLE_NAME", nullable = false)
    private String roleName;

    @Column(name = "ROLE_DESCRIPTION")
    private String roleDescription;
    
}
