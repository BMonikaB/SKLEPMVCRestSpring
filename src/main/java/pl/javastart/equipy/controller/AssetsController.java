package pl.javastart.equipy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.javastart.equipy.DTO.AssetDTO;
import pl.javastart.equipy.domain.Asset;
import pl.javastart.equipy.repository.AssetRepository;
import pl.javastart.equipy.service.AsserService;

import java.util.List;


@RestController
@RequestMapping("/api/assets")
public class AssetsController {

    @Autowired
    AsserService asserService;
    @Autowired

    @GetMapping("")
    public List<AssetDTO> getAllAssets(){
        return asserService.getAllAssets();
    }

}
