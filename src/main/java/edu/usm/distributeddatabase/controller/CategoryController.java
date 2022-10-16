package edu.usm.distributeddatabase.controller;

import edu.usm.distributeddatabase.entity.Category;
import edu.usm.distributeddatabase.entity.Product;
import edu.usm.distributeddatabase.model.CategoryDTO;
import edu.usm.distributeddatabase.model.ProductDTO;
import edu.usm.distributeddatabase.service.CategoryService;
import edu.usm.distributeddatabase.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories")
@Slf4j
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;

    @GetMapping()
    public ResponseEntity<List<CategoryDTO>> getCategories() {
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        categoryService.getAllCategories().forEach(category -> {
            categoryDTOList.add(buildCategoryDTO(category));
        });
        return new ResponseEntity<>(categoryDTOList, HttpStatus.OK);
    }

    @GetMapping("/{categoryId}/products")
    public ResponseEntity<List<ProductDTO>> getProductsByCategory(@PathVariable(value = "categoryId") Integer categoryId) {
        List<ProductDTO> productDTOList = new ArrayList<>();
        productService.getAllProductsByCategory(categoryId).forEach(product -> {
            productDTOList.add(buildProductDTO(product));
        });
        return ResponseEntity.ok(productDTOList);
    }

    private CategoryDTO buildCategoryDTO(Category category) {
        return CategoryDTO.builder()
                .categoryId(category.getCategoryId())
                .categoryName(category.getCategoryName())
                .build();
    }

    private ProductDTO buildProductDTO(Product product) {
        return ProductDTO.builder()
                .categoryId(product.getCategory().getCategoryId())
                .prdId(product.getPrdId())
                .prdCode(product.getPrdCode())
                .prdName(product.getPrdName())
                .prdDesc(product.getPrdDesc())
                .prdImgUrl(product.getPrdImgUrl())
                .prdPrice(product.getPrdPrice())
                .build();
    }
}
