package com.interstellarcarrental.carrental.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SuperBuilder
@Data
@NoArgsConstructor
public abstract class User implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Column(name = "USER_PRIM_KEY", nullable = false, unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    @Column(name = "USERNAME", nullable = false, unique = true)
    protected String username;

    @Column(name = "PASSWORD", nullable = false)
    protected String password;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ROLE",
               joinColumns = @JoinColumn(name = "USER_PRIM_KEY"),
               inverseJoinColumns = @JoinColumn(name = "ROLE_PRIM_KEY"))
    protected transient Set<Role> roles = new HashSet<>();

    @Column(name = "ENABLED", nullable = false)
    protected boolean isEnabled;

    @Column(name = "FIRST_NAME", nullable = false)
    protected String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    protected String lastName;

    @Column(name = "BIRTH_DATE", nullable = false)
    protected LocalDate birthDate;

    @Column(name = "EMAIL", nullable = false, unique = true)
    protected String emailAddress;

    @Column(name = "PHONE_NR", nullable = false)
    protected String phoneNumber;

    @Column(name = "ADDRESS", nullable = false)
    protected String address;

    @Column(name = "CREDITCARD_NR", unique = true)
    protected String creditCardNumber;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "USER")
    protected transient List<Car> currentlyRentedCars = new ArrayList<>();
}
