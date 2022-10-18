package edu.usm.distributeddatabase.controller;


import edu.usm.distributeddatabase.repo.CategoryRepo;
import edu.usm.distributeddatabase.service.CategoryService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
//@RunWith(JUnitPlatform.class)
public class CategoryControllerTest {
    @InjectMocks
    CategoryController categoryController;
    @Mock
    CategoryService categoryService;

}
