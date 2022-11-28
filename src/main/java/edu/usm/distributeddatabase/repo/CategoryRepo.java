package edu.usm.distributeddatabase.repo;

import edu.usm.distributeddatabase.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
/**
 * Data Access Layer, for Manage Categories
 */
public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
