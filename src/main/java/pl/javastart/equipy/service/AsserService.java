package pl.javastart.equipy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.javastart.equipy.DTO.AssetDTO;
import pl.javastart.equipy.Mapper.AssetMapper;
import pl.javastart.equipy.domain.Asset;
import pl.javastart.equipy.repository.AssetRepository;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class AsserService {

    @Autowired
    AssetRepository assetRepository;

    private AssetMapper assetMapper = new AssetMapper();

    public List<AssetDTO> getAllAssets(){
        return assetRepository.findAll().stream().map(assetMapper::toAsset).collect(Collectors.toList());
    }

}
