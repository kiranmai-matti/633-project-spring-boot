package edu.usm.distributeddatabase.service;

import edu.usm.distributeddatabase.entity.Category;
import edu.usm.distributeddatabase.entity.Product;
import edu.usm.distributeddatabase.exception.NotFoundException;
import edu.usm.distributeddatabase.repo.CategoryRepo;
import edu.usm.distributeddatabase.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final CategoryRepo categoryRepo;
    private final ProductRepo productRepo;

    /**
     * This Method os used to list all the associated products for the provided category ID
     * @param categoryId Category Id
     * @return List<Product>
     */
    public List<Product> getAllProductsByCategory(Integer categoryId) {
        List<Product> productList = Collections.emptyList();
        Optional<Category> optionalCategory = categoryRepo.findById(categoryId);
        if (optionalCategory.isPresent())
            productList = productRepo.findProductsByCategory(optionalCategory.get());
        else{
            throw new NotFoundException("No Products Found for the given category "+categoryId);
        }
        return productList;
    }
}
