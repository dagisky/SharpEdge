package com.sharpEdge.cards.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Data
@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@EntityListeners(AuditingEntityListener.class)
public class Auditable {
    @Column(nullable = false, updatable = false)
    @CreatedDate
    private long created;
    @LastModifiedDate
    private long modified;
}
