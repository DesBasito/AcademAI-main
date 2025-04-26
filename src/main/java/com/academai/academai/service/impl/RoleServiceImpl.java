package com.academai.academai.service.impl;

import com.academai.academai.entity.Role;
import com.academai.academai.repository.RoleRepository;
import com.academai.academai.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Role findByName(String name){
        return roleRepository.findByRole(name).orElse(null);
    }
}
