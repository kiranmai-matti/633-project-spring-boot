package edu.usm.distributeddatabase.service;

import edu.usm.distributeddatabase.entity.Customer;
import edu.usm.distributeddatabase.exception.NotFoundException;
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
/**
 * CategoryService
 * Service Layer to return the Avaliable Categories within the application
 */
public class CustomerService {
    private final CustomerRepo customerRepo;

    /**
     * This Method is used to save the custome information into the database
     * @param customer Customer Details
     * @return Integer
     */
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

    /**
     * This Method is used to validate the customer login process for the given email & password combination
     * @param email Customer's Email Id
     * @param password Customer's password
     * @return boolean
     */
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

    /**
     * This method is used to find the customer exists by email or not hased password against the plainText.
     * see Customer for more details
     * @param email Customer's Email Id
     * @return Customer
     */
    public Customer getCustomerPresentByEmail(String email) {
        Optional<Customer> optionalCustomer = customerRepo.findByEmail(email);
        return optionalCustomer.orElse(null);
    }

    /**
     * This method is used to create hased based password for the plainText.
     * see BCrypt.hashpw for more details
     * @param plainText plain form of customer password
     * @return String
     */
    private String hashPassword(String plainText) {
        return BCrypt.hashpw(plainText, BCrypt.gensalt(6));
    }


    /**
     * This method is used to validate hased password against the plainText.
     * see BCrypt.hashpw for more details
     * @param plainText plain form of customer password
     * @param hashedPassword hashed pwd of customer's plainText
     * @return boolean
     */
    private boolean validatePassword(String plainText, String hashedPassword) {
        return BCrypt.checkpw(plainText, hashedPassword);
    }
}
