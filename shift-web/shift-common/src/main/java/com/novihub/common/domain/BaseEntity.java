package com.novihub.common.domain;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class BaseEntity {

	@Id
    @GeneratedValue
    private Long id;
	
	@Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private ZonedDateTime createdDate;

    @Column(name = "modified_date")
    @LastModifiedDate
    private ZonedDateTime modifiedDate;
	
}
