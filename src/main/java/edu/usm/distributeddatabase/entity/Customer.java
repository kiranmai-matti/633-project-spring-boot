package edu.usm.distributeddatabase.entity;


import lombok.*;

import javax.persistence.*;
import javax.sql.rowset.serial.SerialArray;
import java.io.Serializable;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "cust_id", nullable = false)
    private Integer custId;
    private String firstName;
    private String lastName;
    private String email;
    private Integer mobileNo;
    private String password;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipping_addr_id")
    private CustAddress shippingAddr;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "billing_addr_id")
    private CustAddress billingAddr;

}
