package edu.usm.distributeddatabase.repo;

import edu.usm.distributeddatabase.entity.Category;
import edu.usm.distributeddatabase.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    //    @Native("select p from product p join category c on c.category_id=p.category_id")
    List<Product> findProductsByCategory(Category category);

}
