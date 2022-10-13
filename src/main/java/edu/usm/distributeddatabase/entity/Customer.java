package edu.usm.distributeddatabase.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "cust_id", nullable = false)
    private Integer custId;
    private String firstName;
    private String lastName;
    private String email;
    private Integer mobileNo;
    private String password;
}
