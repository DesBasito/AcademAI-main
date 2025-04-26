package com.academai.academai.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime deadline;
    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "task")
    private List<Work> works;
}
