package edu.usm.distributeddatabase.service;

import edu.usm.distributeddatabase.entity.Category;
import edu.usm.distributeddatabase.repo.CategoryRepo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {
    @InjectMocks
    CustomerService customerService;
    @Mock
    CategoryRepo categoryRepo;
    @Mock
    List<Category> categoryList;
}
