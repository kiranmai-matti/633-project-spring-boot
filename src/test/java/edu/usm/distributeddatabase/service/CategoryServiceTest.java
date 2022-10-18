package edu.usm.distributeddatabase.service;

import edu.usm.distributeddatabase.entity.Category;
import edu.usm.distributeddatabase.repo.CategoryRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {
    @InjectMocks
    CategoryService categoryService;
    @Mock
    CategoryRepo categoryRepo;
    @Mock
    List<Category> categoryList;

    @Test
    void testGetAllCategories_Empty() {
        when(categoryRepo.findAll()).thenReturn(categoryList);
        Assertions.assertDoesNotThrow(() -> categoryService.getAllCategories());
        Assertions.assertEquals(categoryList, categoryService.getAllCategories());

    }

    @Test
    void testGetAllCategories_NotEmpty() {
        List<Category> categoryList = List.of(new Category(1, null, "category 1", null), new Category(2, null, "category 2", null));
        when(categoryRepo.findAll()).thenReturn(categoryList);
        List<Category> serviceAllCategories = categoryService.getAllCategories();
        Assertions.assertDoesNotThrow(() -> serviceAllCategories);
        Assertions.assertEquals(categoryList, serviceAllCategories);
        Mockito.verify(categoryRepo, times(1)).findAll();
        Assertions.assertEquals(2, serviceAllCategories.size());
        Assertions.assertEquals("category 2", serviceAllCategories.get(1).getCategoryName());
    }
}
