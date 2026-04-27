package com.devprofileproject.devprofileaast.domain.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.devprofileproject.devprofileaast.domain.GitHubProfile;

public interface GitHubProfileRepository extends JpaRepository<GitHubProfile, Long> {
    // optional 3lshan yhmek mn el crash lw sessionId b null
    Optional<GitHubProfile> findBySession_ID(long id);

    boolean existsBySessionId(Long sessionId);

}
