package com.novihub.hr.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.novihub.common.domain.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="hr_employee")
@Getter
@Setter
public class Employee extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "fk_hr_person")
	private Person person;
	private String number;
	private String alias;
	
	
}
