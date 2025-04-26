package com.academai.academai.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LessonDto {
    private Long id;
    private String title;
    private List<MaterialDto> materials;
    private List<TaskDto> tasks;
}
