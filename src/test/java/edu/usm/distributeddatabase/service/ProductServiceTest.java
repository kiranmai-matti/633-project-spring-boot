package edu.usm.distributeddatabase.service;


import edu.usm.distributeddatabase.entity.Category;
import edu.usm.distributeddatabase.entity.Product;
import edu.usm.distributeddatabase.repo.CategoryRepo;
import edu.usm.distributeddatabase.repo.ProductRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @InjectMocks
    ProductService productService;
    @Mock
    ProductRepo productRepo;
    @Mock
    CategoryRepo categoryRepo;
    @Mock
    List<Product> productList;
    Category category = new Category(1, null, "category 1", null);
    Set<Product> productSet = Set.of(new Product(1, category, "product 1", "product 1 description", 399.0, 1234, null));

    @Test
    void testGetAllProductsByCategory_Empty() {
        Optional<Category> optionalCategory = Optional.of(category);
        when(categoryRepo.findById(anyInt())).thenReturn(optionalCategory);
        when(productRepo.findProductsByCategory(any())).thenReturn(productList);
        Assertions.assertDoesNotThrow(() -> productService.getAllProductsByCategory(1));
        Assertions.assertEquals(productList, productService.getAllProductsByCategory(1));
    }

    @Test
    void testGetAllProductsByCategory_NotEmpty() {
        category.setProducts(productSet);
        List<Product> products = new ArrayList<>(productSet);

        Optional<Category> optionalCategory2 = Optional.of(category);
        when(categoryRepo.findById(anyInt())).thenReturn(optionalCategory2);
        when(productRepo.findProductsByCategory(any())).thenReturn(products);
        Assertions.assertDoesNotThrow(() -> productService.getAllProductsByCategory(1));
        Assertions.assertEquals(1234, productService.getAllProductsByCategory(1).get(0).getPrdCode());

    }
}
