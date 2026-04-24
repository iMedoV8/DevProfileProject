CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(120) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    enabled BOOLEAN NOT NULL DEFAULT TRUE,
    role VARCHAR(20) NOT NULL DEFAULT 'USER'
);

CREATE TABLE github_profiles (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(255),
    total_repos INTEGER,
    total_stars INTEGER,
    contributions_last_year INTEGER,
    session_id BIGINT NOT NULL,
    user_id BIGINT,
    CONSTRAINT fk_github_user
        FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT fk_github_profile_session
        FOREIGN KEY (session_id) REFERENCES analysis_sessions(id) ON DELETE CASCADE,
    CONSTRAINT uq_github_profile_session UNIQUE (session_id)
);
