package com.academai.academai.controller;

import com.academai.academai.dto.MaterialDto;
import com.academai.academai.service.MaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/materials")
public class MaterialController {
    private final MaterialService materialService;
}
