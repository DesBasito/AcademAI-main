package com.academai.academai.repository;

import com.academai.academai.entity.RefreshSession;
import com.academai.academai.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RefreshSessionRepository extends JpaRepository<RefreshSession, Long> {
    Optional<RefreshSession> findByRefreshToken(UUID refreshToken);

    void deleteByRefreshToken(UUID refreshToken);

    List<RefreshSession> findByUserOrderByCreatedAtAsc(User user, Pageable pageable);

}
