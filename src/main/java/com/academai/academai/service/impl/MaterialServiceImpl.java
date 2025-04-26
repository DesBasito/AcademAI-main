package com.academai.academai.service.impl;

import com.academai.academai.dto.MaterialDto;
import com.academai.academai.entity.Material;
import com.academai.academai.repository.MaterialRepository;
import com.academai.academai.service.MaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class MaterialServiceImpl implements MaterialService {
    private final MaterialRepository materialRepository;


    @Override
    public Material getMaterialById(Long materialId){
        return materialRepository.findById(materialId).orElseThrow(()->new NoSuchElementException("Material not found"));
    }

    @Override
    public List<MaterialDto> convertToListMaterialDto(List<Material> materials){
        return materials.stream().map(this::convertToMaterialDto).toList();
    }

    @Override
    public MaterialDto convertToMaterialDto(Material material){
        return MaterialDto.builder()
                .id(material.getId())
                .title(material.getTitle())
                .description(material.getDescription())
                .build();
    }
}
