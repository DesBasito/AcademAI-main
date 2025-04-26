package com.academai.academai.service;

import com.academai.academai.dto.TaskDto;
import com.academai.academai.entity.Task;

import java.util.List;

public interface TaskService {
    List<TaskDto> convertToListTaskDto(List<Task> tasks);

    TaskDto convertToTaskDto(Task task);
}
