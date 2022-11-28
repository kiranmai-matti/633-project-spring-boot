package edu.usm.distributeddatabase.controller;

import edu.usm.distributeddatabase.entity.Customer;
import edu.usm.distributeddatabase.mapper.ModelMapper;
import edu.usm.distributeddatabase.model.CustomerDTO;
import edu.usm.distributeddatabase.service.CustomerService;
import edu.usm.distributeddatabase.model.LoginRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers")
@Slf4j
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ModelMapper modelMapper;

    /**
     * This Method is used to validate Customer's Login process for the given email & password combination
     * @param loginRequest holds email & password
     * @return CustomerDTO
     */
    @PostMapping("/login")
    public ResponseEntity<CustomerDTO> loginCustomer(@RequestBody LoginRequest loginRequest) {
        Customer customerByEmail = customerService.getCustomerPresentByEmail(loginRequest.getEmail());
        CustomerDTO customerDTO = modelMapper.buildCustomerDTO(customerByEmail);
        if (customerService.validateCustomer(loginRequest.getEmail(), loginRequest.getPassword()))
            return new ResponseEntity<>(customerDTO, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }

    /**
     * This Method is used to save the customer's details into the application's database
     * @param customer Customer Information Object
     * @return Integer
     */
    @PostMapping("/register")
    public ResponseEntity<Integer> registerCustomer(@RequestBody Customer customer) {
        log.info("register Customer with email {}", customer.getEmail());
        Integer custId = customerService.saveCustomer(customer);
        return new ResponseEntity<>(custId, HttpStatus.OK);
    }

}
