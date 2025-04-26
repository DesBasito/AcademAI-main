package com.academai.academai.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ai_review")
public class AiReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
