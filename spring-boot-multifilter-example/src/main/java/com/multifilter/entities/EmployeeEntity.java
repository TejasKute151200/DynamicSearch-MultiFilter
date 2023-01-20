package com.multifilter.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "employee")
@Where(clause = "is_active=true")
@SQLDelete(sql = "UPDATE employee SET is_active=false WHERE id=?")
public class EmployeeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "employee_name")
	private String employeeName;

	@Column(name = "salary")
	private double salary;

	@Column(name = "email")
	private String email;

	@Column(name = "mobile")
	private String mobile;

	@Column(name = "address")
	private String address;

	@Column(name = "pincode")
	private double pincode;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "branch_id", referencedColumnName = "id")
	private BranchEntity branch;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "department_id", referencedColumnName = "id")
	private DepartmentEntity department;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "designation_id", referencedColumnName = "id")
	private DesignationEntity designation;

}
