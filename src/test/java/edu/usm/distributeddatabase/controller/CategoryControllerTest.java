package edu.usm.distributeddatabase.controller;


import edu.usm.distributeddatabase.entity.Category;
import edu.usm.distributeddatabase.entity.Product;
import edu.usm.distributeddatabase.mapper.ModelMapper;
import edu.usm.distributeddatabase.model.CategoryDTO;
import edu.usm.distributeddatabase.service.CategoryService;
import edu.usm.distributeddatabase.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryControllerTest {
    @InjectMocks
    CategoryController categoryController;
    @Mock
    CategoryService categoryService;
    @Mock
    ProductService productService;
    @Mock
    ModelMapper modelMapper;
    @Mock
    List<Category> categoryList;
    @Mock
    List<Product> productList;

    @Test
    void testGetCategories() {
        when(categoryService.getAllCategories()).thenReturn(categoryList);
        Assertions.assertDoesNotThrow(() -> categoryController.getCategories());
        Assertions.assertInstanceOf(ResponseEntity.class, categoryController.getCategories());
        Assertions.assertNotNull(categoryController.getCategories());
    }

    @Test
    void testGetProductsByCategory() {
        when(productService.getAllProductsByCategory(anyInt())).thenReturn(productList);
        Assertions.assertDoesNotThrow(() -> categoryController.getProductsByCategory(1));
        Assertions.assertInstanceOf(ResponseEntity.class, categoryController.getProductsByCategory(1));
        Assertions.assertNotNull(categoryController.getProductsByCategory(1));
    }

}
