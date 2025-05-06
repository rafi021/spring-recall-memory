package com.ibrahim.store.entities;

import jakarta.persistence.*;
import jdk.jfr.Unsigned;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false, name = "bio")
    private String bio;

    @Column(nullable = false, name = "phone_number")
    private String phoneNumber;

    @Column(nullable = false, name = "date_of_birth")
    private String dateOfBirth;

    @Column(nullable = false, name = "loyalty_points")
    private int loyaltyPoints;

    @OneToOne()
    @JoinColumn(name = "user_id")
    @MapsId
    @ToString.Exclude
    private User user;
}
