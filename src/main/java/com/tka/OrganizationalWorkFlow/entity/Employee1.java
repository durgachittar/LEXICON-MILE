package com.tka.OrganizationalWorkFlow.entity;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
//all anotations ..jakarta.persistance
//all Database..javax.persistence
public class Employee1 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String mobileno;
	private String emailid;
	private double salary;
	private String department;
	private String status;
	private String createdBy;
	private Date createdDate;
	private String upDatedBy;
	private Date updatedDate;
	@ManyToOne
	@JoinColumn(name="cid")//will create a new colum cid in Empployee table
	private Country country;



}
