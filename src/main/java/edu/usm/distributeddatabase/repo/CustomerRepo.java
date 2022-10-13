package edu.usm.distributeddatabase.repo;

import edu.usm.distributeddatabase.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    Optional<Customer> findByEmail(String email);

}
