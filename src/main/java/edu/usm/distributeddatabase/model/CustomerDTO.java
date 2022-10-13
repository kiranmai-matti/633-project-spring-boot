package edu.usm.distributeddatabase.model;

import edu.usm.distributeddatabase.entity.CustAddress;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomerDTO {
    private String firstName;
    private String lastName;
    private String email;
    private Integer mobileNo;
    private CustAddress billingAddr;
    private CustAddress shippingAddr;
}