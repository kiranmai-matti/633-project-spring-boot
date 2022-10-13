package edu.usm.distributeddatabase.controller;

import edu.usm.distributeddatabase.entity.Customer;
import edu.usm.distributeddatabase.repo.CustomerRepo;
import edu.usm.distributeddatabase.service.CustomerService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers")
@Slf4j
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping()
    public void loginCustomer(@RequestParam String email,@RequestParam String password) {
        customerService.validateCustomer(email,password);

    }
    @PostMapping()
    public void registerCustomer(@RequestBody Customer customer){
        log.info("register Customer with email {}",customer.getEmail());
        customerService.saveCustomer(customer);
    }
}
