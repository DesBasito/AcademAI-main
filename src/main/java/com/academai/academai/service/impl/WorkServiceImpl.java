package com.academai.academai.service.impl;

import com.academai.academai.repository.WorkRepository;
import com.academai.academai.service.interfaces.WorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkServiceImpl implements WorkService {
    private final WorkRepository workRepository;
}
