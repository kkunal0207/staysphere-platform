package com.staysphere.platform.entity;

import com.staysphere.platform.entity.enums.Roles;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "platform_user")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String emailId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String phoneNumber;

    @ElementCollection(fetch = FetchType.EAGER) //@ElementCollection will create a new table with name
                                                // platform_user_roles and store all the roles there
    @Enumerated(value = EnumType.STRING)
    private Set<Roles> roles;
}
