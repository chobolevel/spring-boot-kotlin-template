package com.template.common.entity

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.hibernate.envers.Audited
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.OffsetDateTime

@Audited
@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
class BaseEntity {
    @CreatedDate
    @Column(nullable = false, updatable = false)
    var createdAt: OffsetDateTime? = null

    @LastModifiedDate
    @Column(nullable = false, updatable = false)
    var updatedAt: OffsetDateTime? = null
}
