package com.academai.academai.service;

import com.academai.academai.dto.MaterialDto;
import com.academai.academai.entity.Material;

import java.util.List;

public interface MaterialService {
    Material getMaterialById(Long materialId);

    List<MaterialDto> convertToListMaterialDto(List<Material> materials);

    //    @Override
    //    public List<MaterialDto> getMaterialsByCourseId(Long courseId){
    //        Course course = courseService.getCourseById(courseId);
    //        List<Material> materials = course.getMaterials();
    //        return materials.stream()
    //                .map(this::convertToMaterialDto)
    //                .toList();
    //    }
    //
    MaterialDto convertToMaterialDto(Material material);
//    List<MaterialDto> getMaterialsByCourseId(Long courseId);
//
//    MaterialDto convertToMaterialDto(Material material);
}
