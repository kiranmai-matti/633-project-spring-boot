package edu.usm.distributeddatabase.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
/**
 * Java Representation class for the Database table Customer
 */
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "cust_id", nullable = false)
    private Integer custId;
    private String firstName;
    private String lastName;
    private String email;
    private Long mobileNo;
    private String password;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipping_addr_id")
    private CustAddress shippingAddr;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "billing_addr_id")
    private CustAddress billingAddr;

}
