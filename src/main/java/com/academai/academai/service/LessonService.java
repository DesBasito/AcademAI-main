package com.academai.academai.service;

import com.academai.academai.dto.LessonDto;
import com.academai.academai.entity.Lesson;

import java.util.List;

public interface LessonService {
    List<LessonDto> convertToListLessonDto(List<Lesson> lessons);

    LessonDto convertToLessonDto(Lesson lesson);
}
