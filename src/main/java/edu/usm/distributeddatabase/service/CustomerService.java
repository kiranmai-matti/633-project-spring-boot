package edu.usm.distributeddatabase.service;

import edu.usm.distributeddatabase.entity.Customer;
import edu.usm.distributeddatabase.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {
    private final CustomerRepo customerRepo;

    public void saveCustomer(Customer customer) {
        Optional<Customer> optionalCustomer = customerRepo.findByEmail(customer.getEmail());
        if (optionalCustomer.isEmpty()) {
            Customer cust = new Customer();
            cust.setFirstName(customer.getFirstName());
            cust.setLastName(customer.getLastName());
            cust.setEmail(customer.getEmail());
            cust.setMobileNo(customer.getMobileNo());
            cust.setPassword(hashPassword(customer.getPassword()));
            customerRepo.save(cust);
            log.info("Customer registered successfully with email {}", customer.getEmail());
        } else {
            log.info("User already exists with email {}", customer.getEmail());
        }
    }

    public void validateCustomer(String email, String password) {
        Optional<Customer> optionalCustomer = customerRepo.findByEmail(email);
        if (optionalCustomer.isPresent()) {
            String hashedPassword = optionalCustomer.get().getPassword();
            if (validatePassword(password, hashedPassword)) {
                log.info("User is authenticated");
            } else {
                log.info("user is not authenticated");
            }
        } else {
            log.info("user is not registered with email {}", email);
        }
    }


    private @NotNull String hashPassword(String plainText) {
        return BCrypt.hashpw(plainText, BCrypt.gensalt());
    }

    private boolean validatePassword(String plainText, String hashedPassword) {
        return BCrypt.checkpw(plainText, hashedPassword);
        
    }
}
