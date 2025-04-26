package com.academai.academai.service.interfaces;

import com.academai.academai.entity.Role;

public interface RoleService {
    Role findByName(String name);
}
