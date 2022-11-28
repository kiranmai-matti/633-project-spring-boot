package edu.usm.distributeddatabase.repo;

import edu.usm.distributeddatabase.entity.Category;
import edu.usm.distributeddatabase.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
/**
 * Data Access Layer, for Manage Products
 */
public interface ProductRepo extends JpaRepository<Product, Integer> {

    /**
     * This method is used to view all the associated products for given category
     * @param category Category
     * @return
     */
    List<Product> findProductsByCategory(Category category);

}
