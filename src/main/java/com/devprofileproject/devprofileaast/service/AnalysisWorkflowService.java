package com.devprofileproject.devprofileaast.Service;

import org.springframework.stereotype.Service;

import com.devprofileproject.devprofileaast.domain.repository.AnalysisSessionRepository;
import com.devprofileproject.devprofileaast.domain.repository.GitHubProfileRepository;
import com.devprofileproject.devprofileaast.domain.repository.GitHubRepositorySnapshotRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional // bnhto 3shan law fe haga bazt y3ml rollback 3ashan el safety bta3 el database
public class AnalysisWorkflowService {

    private final AnalysisSessionRepository sessionRepository;
    private final GitHubClientService gitHubClientService;
    private final GitHubProfileRepository gitHubProfileRepository;
    private final GitHubRepositorySnapshotRepository gitHubRepositorySnapshotRepository;
    private final ResumePdfParserService resumePdfParserService;
    private final ResumeProfileRepository resumeProfileRepository;

}
