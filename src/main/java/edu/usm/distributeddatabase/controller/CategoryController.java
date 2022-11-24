package edu.usm.distributeddatabase.controller;

import edu.usm.distributeddatabase.mapper.ModelMapper;
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
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping()
    public ResponseEntity<List<CategoryDTO>> getCategories() {
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        categoryService.getAllCategories().forEach(category -> {
            categoryDTOList.add(modelMapper.buildCategoryDTO(category));
        });
        return new ResponseEntity<>(categoryDTOList, HttpStatus.OK);
    }

    @GetMapping("/{categoryId}/products")
    public ResponseEntity<List<ProductDTO>> getProductsByCategory(@PathVariable(value = "categoryId") Integer categoryId) {
        List<ProductDTO> productDTOList = new ArrayList<>();
        productService.getAllProductsByCategory(categoryId).forEach(product -> {
            productDTOList.add(modelMapper.buildProductDTO(product));
        });
        return ResponseEntity.ok(productDTOList);
    }


}
