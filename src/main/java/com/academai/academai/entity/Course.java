package com.academai.academai.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String image;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
    private List<Module> modules;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
    private List<Enrollment> enrollments;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
