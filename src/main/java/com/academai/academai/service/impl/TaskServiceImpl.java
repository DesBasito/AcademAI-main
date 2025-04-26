package com.academai.academai.service.impl;

import com.academai.academai.dto.TaskDto;
import com.academai.academai.entity.Task;
import com.academai.academai.repository.TaskRepository;
import com.academai.academai.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;


    @Override
    public List<TaskDto> convertToListTaskDto(List<Task> tasks){
        return tasks.stream().map(this::convertToTaskDto).toList();
    }

    @Override
    public TaskDto convertToTaskDto(Task task){
        return TaskDto.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .deadline(task.getDeadline())
                .build();
    }
}
