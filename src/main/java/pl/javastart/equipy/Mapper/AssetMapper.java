package pl.javastart.equipy.Mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.javastart.equipy.DTO.AssetDTO;
import pl.javastart.equipy.domain.Asset;
import pl.javastart.equipy.domain.Category;
import pl.javastart.equipy.repository.CategoryRepository;

@Service
public class AssetMapper {

    @Autowired
    CategoryRepository categoryRepository;

    public AssetDTO toAsset(Asset asset) {
        AssetDTO assetDTO = new AssetDTO();
        assetDTO.setId(asset.getId());
        assetDTO.setName(asset.getName());
        assetDTO.setDescription(asset.getDescription());
        assetDTO.setSerialNumber(asset.getSerialNumber());
        assetDTO.setCategory(asset.getCategory().getName());
        return assetDTO;
    }

    public Asset toAssetDto(AssetDTO assetDTO) {
        Asset asset = new Asset();
        asset.setId(assetDTO.getId());
        asset.setName(assetDTO.getName());
        asset.setDescription(asset.getDescription());

        Category category =categoryRepository.findByName(assetDTO.getCategory());
        assetDTO.setCategory(category.getName());
        asset.setSerialNumber(asset.getSerialNumber());
        return asset;
    }

}
