package edu.usm.distributeddatabase.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cust_address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustAddress implements Serializable {
    @Id
    @Column(name = "cust_address_id", nullable = false)
    @JsonIgnore
    private Integer custAddressId;
    @Column(name = "addr_1", nullable = false, length = 50)
    private String addr1;
    @Column(name = "addr_2", nullable = false, length = 50)
    private String addr2;
    private String city;
    private String state;
    private Integer zipcode;
    private String country;

}