package edu.usm.distributeddatabase.service;

import edu.usm.distributeddatabase.entity.Customer;
import edu.usm.distributeddatabase.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {
    private final CustomerRepo customerRepo;

    public Integer saveCustomer(Customer customer) {
        Customer cust = getCustomerPresentByEmail(customer.getEmail());
        if (Objects.isNull(cust)) {
            Customer build = Customer.builder()
                    .firstName(customer.getFirstName())
                    .lastName(customer.getLastName())
                    .email(customer.getEmail())
                    .mobileNo(customer.getMobileNo())
                    .password(hashPassword(customer.getPassword()))
                    .build();
            Customer savedCustomer = customerRepo.save(build);
            log.info("Customer registered successfully with email {}", customer.getEmail());
            return savedCustomer.getCustId();
        } else {
            log.info("User already exists with email {}", customer.getEmail());
            return cust.getCustId();
        }
    }

    public boolean validateCustomer(String email, String password) {
        Customer customer = getCustomerPresentByEmail(email);
        if (!Objects.isNull(customer)) {
            String hashedPassword = customer.getPassword();
            if (validatePassword(password, hashedPassword)) {
                log.info("User is authenticated");
                return true;
            } else {
                log.info("user is not authenticated");
                return false;
            }
        } else {
            log.info("user is not registered with email {}", email);
            return false;
        }
    }

    public Customer getCustomerPresentByEmail(String email) {
        Optional<Customer> optionalCustomer = customerRepo.findByEmail(email);
        return optionalCustomer.orElse(null);
    }


    private String hashPassword(String plainText) {
        return BCrypt.hashpw(plainText, BCrypt.gensalt(6));
    }

    private boolean validatePassword(String plainText, String hashedPassword) {
        return BCrypt.checkpw(plainText, hashedPassword);
    }
}
