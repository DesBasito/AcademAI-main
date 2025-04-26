package com.academai.academai.entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String avatar;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
    private boolean enabled;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Work> works;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Enrollment> enrollments;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<RefreshSession> refreshSessions;
}
