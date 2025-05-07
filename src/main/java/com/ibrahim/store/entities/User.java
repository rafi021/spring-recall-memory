package com.ibrahim.store.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Long id;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = false, name = "email")
    private String email;

    @Column(nullable = false, name = "password")
    private String password;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    @Builder.Default
    private List<Address> addresses = new ArrayList<>();
    @ManyToMany
    @JoinTable(
            name = "user_tags",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    @Builder.Default
    private Set<Tag> tags = new HashSet<>();
    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE)
    private Profile profile;

    public void addAddress(Address address){
        addresses.add(address);
        address.setUser(this);
    }

    public void removeAddrees(Address address){
        addresses.remove(address);
        address.setUser(null);
    }

    public void addTag(String tagName){
        var tag = new Tag(tagName);
        tags.add(tag);
        tag.getUsers().add(this);
    }

    public void removeTag(Tag tag){
        tags.remove(tag);
        tag.getUsers().remove(this);
    }

    public void addProfile(Profile profile){
        this.setProfile(profile);
        profile.setUser(this);
    }

    public void removeProfile(Profile profile){
        this.removeProfile(profile);
        profile.setUser(null);
    }
}
