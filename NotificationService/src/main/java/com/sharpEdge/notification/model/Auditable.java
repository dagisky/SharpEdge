package com.sharpEdge.notification.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Auditable {
    @Column(name = "sent_date", nullable = false, updatable = false)
    @CreatedDate
    private long sentDate;
}
