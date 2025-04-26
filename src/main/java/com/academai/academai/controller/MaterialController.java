package com.academai.academai.controller;

import com.academai.academai.service.interfaces.MaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/materials")
public class MaterialController {
    private final MaterialService materialService;
}
