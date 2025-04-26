package com.academai.academai.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;


import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Accessors(chain = true)
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String surname;
    String email;
    String password;
    String avatar;
    String activationCode;
    @ManyToOne
    @JoinColumn(name = "role_id")
    Role role;
    boolean enabled;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    List<Work> works;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    List<Enrollment> enrollments;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    List<RefreshSession> refreshSessions;
}
