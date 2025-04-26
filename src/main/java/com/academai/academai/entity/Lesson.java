package com.academai.academai.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "lesson")
    private List<Material> materials;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "lesson")
    private List<Task> tasks;
}
