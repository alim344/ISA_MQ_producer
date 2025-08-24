package com.example.bunnycare.model;

import jakarta.persistence.*;

@Entity
public class BunnyCareInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true)
    private String shelter_name;

   @OneToOne(cascade = CascadeType.ALL)       //moze i many to one, ako npr u istoj zgradi ima vise veterinara
   @JoinColumn(name = "location_id", unique = true)
   private Location location;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShelter_name() {
        return shelter_name;
    }

    public void setShelter_name(String shelter_name) {
        this.shelter_name = shelter_name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
