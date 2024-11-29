package com.example.SecurityPlayground.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "users")
@Data
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    Long id;

    @Column
    Long githubUsernameID;

    @Column
    String githubUsername;

    public User(Long id, Long githubUsernameID, String githubUsername) {
        this.id = id;
        this.githubUsernameID = githubUsernameID;
        this.githubUsername = githubUsername;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGithubUsernameID() {
        return githubUsernameID;
    }

    public void setGithubUsernameID(Long githubUsernameID) {
        this.githubUsernameID = githubUsernameID;
    }

    public String getGithubUsername() {
        return githubUsername;
    }

    public void setGithubUsername(String githubUsername) {
        this.githubUsername = githubUsername;
    }
}
