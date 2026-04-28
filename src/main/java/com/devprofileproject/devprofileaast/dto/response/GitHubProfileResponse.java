package com.devprofileproject.devprofileaast.dto.response;

import java.util.List;

import com.devprofileproject.devprofileaast.dto.auth.GitHubRepositorySnapshotResponse;

//da class el response ely hanstakhdmo f na'l el data ll frontend 3lshan kda kolo getters
public class GitHubProfileResponse {
    
    private String username;
    private int totalRepos;
    private int totalStars;
    private int contributionsLastYear;
    private List<GitHubRepositorySnapshotResponse> topRepositories;

    public GitHubProfileResponse(String username, int totalRepos, int totalStars, int contributionsLastYear,List<GitHubRepositorySnapshotResponse> topRepositories) {
        this.username = username;
        this.totalRepos = totalRepos;
        this.totalStars = totalStars;
        this.contributionsLastYear = contributionsLastYear;
        this.topRepositories = topRepositories;
    }

    public String getUsername(){return username;}

    public int getTotalRepos(){return totalRepos;}

    public int getTotalStars(){return totalStars;}

    public int getContributionsLastYear(){return contributionsLastYear;}

    public List<GitHubRepositorySnapshotResponse> getTopRepositories(){return topRepositories;}
    


}
