package org.example.ecommerce.repositories;

import org.example.ecommerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
        Category findByCategoryName(String categoryName);
}
