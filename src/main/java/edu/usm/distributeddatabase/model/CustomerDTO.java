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
/**
 * Data Transformed Class
 */
public class CustomerDTO {
    private String firstName;
    private String lastName;
    private String email;
    private Long mobileNo;
    private CustAddress billingAddr;
    private CustAddress shippingAddr;
}