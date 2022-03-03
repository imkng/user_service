package com.multiclient.userservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int userId;
    private String userName;
    private String email;
    private Integer mobileNumber;
    private String address;
    private String password;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="role")
    private Roles role;


}
