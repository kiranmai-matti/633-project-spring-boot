package edu.usm.distributeddatabase.controller;

import edu.usm.distributeddatabase.entity.CustAddress;
import edu.usm.distributeddatabase.entity.Customer;
import edu.usm.distributeddatabase.model.CustomerDTO;
import edu.usm.distributeddatabase.service.CustomerService;
import edu.usm.distributeddatabase.service.LoginRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers")
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/login")
    public ResponseEntity<String> loginCustomer(@RequestBody LoginRequest loginRequest) {
        Customer customerByEmail = customerService.getCustomerPresentByEmail(loginRequest.getEmail());
        if (Objects.isNull(customerByEmail)) {
            return new ResponseEntity<>("Customer is not registered", HttpStatus.NOT_FOUND);
        } else {
            if (customerService.validateCustomer(loginRequest.getEmail(), loginRequest.getPassword()))
                return new ResponseEntity<>("Customer logged in successfully", HttpStatus.OK);
            else
                return new ResponseEntity<>("Invalid Email/Password", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Integer> registerCustomer(@RequestBody Customer customer) {
        log.info("register Customer with email {}", customer.getEmail());
        Integer custId = customerService.saveCustomer(customer);
        return new ResponseEntity<>(custId, HttpStatus.OK);
    }

    @GetMapping("/{email}/info")
    public ResponseEntity<CustomerDTO> getCustomerInfo(@PathVariable("email") String email) {
        Customer customerByEmail = customerService.getCustomerPresentByEmail(email);
        CustomerDTO customerDTO = CustomerDTO.builder()
                .firstName(customerByEmail.getFirstName())
                .lastName(customerByEmail.getLastName())
                .mobileNo(customerByEmail.getMobileNo())
                .email(customerByEmail.getEmail())
                .billingAddr(getAddress(customerByEmail.getBillingAddr()))
                .shippingAddr(getAddress(customerByEmail.getShippingAddr()))
                .build();
        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }

    private CustAddress getAddress(CustAddress custAddress) {
        return CustAddress.builder()
                .addr1(custAddress.getAddr1())
                .addr2(custAddress.getAddr2())
                .city(custAddress.getCity())
                .state(custAddress.getState())
                .zipcode(custAddress.getZipcode())
                .country(custAddress.getCountry())
                .build();
    }
}
