package com.academai.academai.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "refresh_sessions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RefreshSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID refreshToken;
    private String fingerprint;
    private String ua;
    private String ip;
    private Long expiresIn;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    private Timestamp createdAt = Timestamp.from(Instant.now());
}

