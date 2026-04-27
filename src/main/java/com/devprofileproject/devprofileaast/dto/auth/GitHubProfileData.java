package com.devprofileproject.devprofileaast.dto.auth;

import java.time.Instant;
import java.util.List;
// DTO INTEGRATION BETWEEN FRONTEND AND BACKEND 

public record GitHubProfileData(
                String username,
                int totalRepos,
                int totalStars,
                int contributionsLastYear,
                List<RepositoryData> topRepositories) {

        public record RepositoryData(
                        String name,
                        String description,
                        String primaryLanguage,
                        int stars,
                        Instant lastUpdated) {
        }
}
