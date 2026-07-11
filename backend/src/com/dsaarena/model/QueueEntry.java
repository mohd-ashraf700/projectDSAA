package com.dsaarena.model;

import java.time.LocalDateTime;

public class QueueEntry {
    private User user;
    private LocalDateTime joinedAt;

    public QueueEntry(User user , LocalDateTime joinedAt){
        this.user = user;
        this.joinedAt = joinedAt;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getJoinedAt() {
        return joinedAt;
    }
}
