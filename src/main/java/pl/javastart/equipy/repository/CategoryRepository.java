package pl.javastart.equipy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.javastart.equipy.DTO.AssetDTO;
import pl.javastart.equipy.domain.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    Category findByName(String category);
}
