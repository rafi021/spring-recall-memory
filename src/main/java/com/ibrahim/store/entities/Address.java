package com.ibrahim.store.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false, name = "street")
    private  String street;

    @Column(nullable = false, name = "city")
    private  String city;

    @Column(nullable = false, name = "zip")
    private  String zip;

    @Column(nullable = false, name = "state")
    private  String state;

}
