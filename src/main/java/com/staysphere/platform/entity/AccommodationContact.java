package com.staysphere.platform.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable // it will add all the fields in accommodation table and
// won't create a new table for this class, and it will add in accomodation class
// bcoz there we have used @Embedded for this class so we don't have to add @Entity or @Table
public class AccommodationContact {

    private String address;
    private String phoneNumber;
    private String emailId;
    private String location;
}
