package edu.usm.distributeddatabase.repo;

import edu.usm.distributeddatabase.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
/**
 * Data Access Layer, for Manage Customers
 */
public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    /**
     * This method is used to check whether the Customer Exists by Email or Not
     * @param email Customer's Email Id
     * @return Optional<Customer>
     */
    Optional<Customer> findByEmail(String email);
}
