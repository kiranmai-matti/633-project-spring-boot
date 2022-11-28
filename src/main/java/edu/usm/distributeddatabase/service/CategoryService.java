package edu.usm.distributeddatabase.service;

import edu.usm.distributeddatabase.entity.Category;
import edu.usm.distributeddatabase.repo.CategoryRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
    /**
     * CategoryService
     * Service Layer to return the Avaliable Categories within the application
     */
public class CategoryService {
    private final CategoryRepo categoryRepo;
    /**
     * This method is used to list all the avaliable categories.
     * see edu.usm.distributeddatabase.entity.Category for more details
     * @return List<Category>
     */
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }
}
