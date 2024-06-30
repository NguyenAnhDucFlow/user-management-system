package com.anhduc.backend.util;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public abstract class AuditAble {

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private Instant createAt;

    @LastModifiedDate
    @Column(nullable = false)
    private Instant updateAt;
}
