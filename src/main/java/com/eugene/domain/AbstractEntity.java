package com.eugene.domain;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@MappedSuperclass
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public abstract class AbstractEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true , nullable = false)
    private Long id;

    @Column(name = "created")
    private Instant createdAt;

    @Column(name = "updated")
    private Instant updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    @PrePersist
    public void toCreate() {
        this.setCreatedAt(Instant.now());
    }

    @PreUpdate
    public void toUpdate() {
        this.setUpdatedAt(Instant.now());
    }
}
