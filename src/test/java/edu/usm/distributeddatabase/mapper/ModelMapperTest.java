package edu.usm.distributeddatabase.mapper;


import edu.usm.distributeddatabase.entity.Category;
import edu.usm.distributeddatabase.entity.Product;
import edu.usm.distributeddatabase.model.CategoryDTO;
import edu.usm.distributeddatabase.model.ProductDTO;
import edu.usm.distributeddatabase.service.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ModelMapperTest {
    @InjectMocks
    ModelMapper modelMapper;
    @Mock
    Category category;
    @Mock
    Product product;

    @Test
    void testCategoryDTOFromCategory() {
        CategoryDTO mockCategoryDTO = mock(CategoryDTO.class);
        CategoryDTO buildCategoryDTO = modelMapper.buildCategoryDTO(category);
        Assertions.assertEquals(buildCategoryDTO.getCategoryName(), mockCategoryDTO.getCategoryName());
        Assertions.assertEquals(buildCategoryDTO.getCategoryId(), mockCategoryDTO.getCategoryId());
    }

    @Test
    void testProductDTOFromProduct() {
        ProductDTO buildProductDTO = modelMapper.buildProductDTO(buildProductEntity());
        Assertions.assertEquals(buildProductDTO.getPrdId(), 1);
        Assertions.assertEquals(buildProductDTO.getPrdCode(), 1234);
        Assertions.assertEquals(buildProductDTO.getPrdName(), "product 1");
        Assertions.assertEquals(buildProductDTO.getPrdPrice(), 399.0);
    }

    Product buildProductEntity() {
        Product product = new Product();
        Category category = new Category(1, null, "category 1", null);
        product.setCategory(category);
        product.setPrdId(1);
        product.setPrdCode(1234);
        product.setPrdName("product 1");
        product.setPrdPrice(399.0);
        return product;
    }
}
