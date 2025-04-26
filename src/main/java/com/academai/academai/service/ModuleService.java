package com.academai.academai.service;

import com.academai.academai.dto.ModuleDto;
import com.academai.academai.entity.Module;

import java.util.List;

public interface ModuleService {
    List<ModuleDto> convertToListModuleDto(List<Module> modules);

    ModuleDto convertToModuleDto(Module module);
}
