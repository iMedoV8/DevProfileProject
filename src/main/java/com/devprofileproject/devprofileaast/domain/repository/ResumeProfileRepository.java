package com.devprofileproject.devprofileaast.domain.repository;

public interface ResumeProfileRepository {

    boolean existsBySessionId(Long sessionId);

}
