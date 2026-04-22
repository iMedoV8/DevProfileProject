// hena User aady wel Entity bat3raf el User lel spring boot

package com.devprofileproject.devprofileaast;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.devprofileproject.devprofileaast.repository.EnumUser.Role;

@Entity
@Table(name ="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // de bet3ml generate lel ID lewahdaha lama user geded yedkhol
    private Long id;

    @Column(unique = true, nullable = false)
    private String emai;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private LocalDateTime createdAt;

    private Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmai() {
        return emai;
    }

    public void setEmai(String emai) {
        this.emai = emai;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPasswordHash(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
