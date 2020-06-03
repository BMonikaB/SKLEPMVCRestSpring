package pl.javastart.equipy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.javastart.equipy.domain.Asset;

public interface AssetRepository extends JpaRepository<Asset,Long> {
}
