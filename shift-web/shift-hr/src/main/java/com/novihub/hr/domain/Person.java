package com.novihub.hr.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.novihub.common.domain.BaseEntity;
import com.novihub.hr.domain.enums.Gender;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="hr_person")
@Getter
@Setter
@Builder
public class Person extends BaseEntity {

	private String name;
	private String surname;
	
	@Column(name = "born_date")
	private LocalDate bornDate;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
}
