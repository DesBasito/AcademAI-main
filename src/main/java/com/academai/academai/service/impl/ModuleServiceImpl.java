package com.academai.academai.service.impl;

import com.academai.academai.dto.ModuleDto;
import com.academai.academai.entity.Module;
import com.academai.academai.repository.ModuleRepository;
import com.academai.academai.service.interfaces.LessonService;
import com.academai.academai.service.interfaces.ModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModuleServiceImpl implements ModuleService {
    private final ModuleRepository moduleRepository;
    private final LessonService lessonService;

    @Override
    public List<ModuleDto> convertToListModuleDto(List<Module> modules){
        return modules.stream().map(this::convertToModuleDto).toList();
    }

    @Override
    public ModuleDto convertToModuleDto(Module module){
        return ModuleDto.builder()
                .id(module.getId())
                .title(module.getTitle())
                .lessons(lessonService.convertToListLessonDto(module.getLessons()))
                .build();
    }
}
