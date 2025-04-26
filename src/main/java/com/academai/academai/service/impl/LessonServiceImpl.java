package com.academai.academai.service.impl;

import com.academai.academai.dto.LessonDto;
import com.academai.academai.entity.Lesson;
import com.academai.academai.repository.LessonRepository;
import com.academai.academai.service.interfaces.LessonService;
import com.academai.academai.service.interfaces.MaterialService;
import com.academai.academai.service.interfaces.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;
    private final MaterialService materialService;
    private final TaskService taskService;


    @Override
    public List<LessonDto> convertToListLessonDto(List<Lesson> lessons){
        return lessons.stream().map(this::convertToLessonDto).toList();
    }


    @Override
    public LessonDto convertToLessonDto(Lesson lesson){
        return LessonDto.builder()
                .id(lesson.getId())
                .title(lesson.getTitle())
                .tasks(taskService.convertToListTaskDto(lesson.getTasks()))
                .materials(materialService.convertToListMaterialDto(lesson.getMaterials()))
                .build();
    }
}
