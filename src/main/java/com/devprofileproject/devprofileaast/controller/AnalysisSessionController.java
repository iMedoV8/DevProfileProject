package com.devprofileproject.devprofileaast.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devprofileproject.devprofileaast.dto.request.CreateSessionRequest;
import com.devprofileproject.devprofileaast.dto.response.AnalysisSessionResponse;
import com.devprofileproject.devprofileaast.security.CustomUserDetails;
import com.devprofileproject.devprofileaast.service.AnalysisSessionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/sessions")
public class AnalysisSessionController {

    private final AnalysisSessionService sessionService;

    public AnalysisSessionController(AnalysisSessionService sessionService) {
        this.sessionService = sessionService;
    }

    @PostMapping
    public ResponseEntity<AnalysisSessionResponse> createSession(
            @Valid @RequestBody CreateSessionRequest request) {
        return ResponseEntity.ok(sessionService.createSession(request.getName()));
    }

    @GetMapping
    public ResponseEntity<List<AnalysisSessionResponse>> getAllSessions() {
        return ResponseEntity.ok(sessionService.getAllSessions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnalysisSessionResponse> getSession(@PathVariable Long id) {
        return ResponseEntity.ok(sessionService.getSession(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> archiveSession(@PathVariable Long id) {
        sessionService.archiveSession(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/start")
    public ResponseEntity<Void> startSession(
            @PathVariable Long id,
            @AuthenticationPrincipal CustomUserDetails userDetails) {
        sessionService.startSession(id, userDetails.getUser().getId());
        return ResponseEntity.ok().build();
    }
}