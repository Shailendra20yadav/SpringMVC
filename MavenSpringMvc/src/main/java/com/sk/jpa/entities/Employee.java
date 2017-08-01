package com.sk.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;


import java.util.Date;
import java.util.List;


/**
 * The persistent class for the EMPLOYEE database table.
 * 
 */
@Entity
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="EMPLOYEE_ID", updatable = false, nullable = false)
	@TableGenerator(name="TABLE_GEN", table="SEQUENCE_TABLE", pkColumnName="SEQ_NAME",
    valueColumnName="SEQ_COUNT", pkColumnValue="EMPLOYEE")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="TABLE_GEN")
	private long employeeId;

	@Temporal(TemporalType.DATE)
	private Date createdon;

	private String email;
	private int enabled;

	private String firstname;

	private int gender;

	private String lastname;

	@Temporal(TemporalType.DATE)
	private Date lastupdatedon;

	private String middlename;

	@Column(name="\"PASSWORD\"")
	private String password;

	private String username;
	
	//bi-directional many-to-one association to Emprole
	@OneToMany(mappedBy="employee", cascade = CascadeType.ALL)
	private List<Emprole> emproles;

	public Employee() {
	}

	public long getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public Date getCreatedon() {
		return this.createdon;
	}

	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getEnabled() {
		return this.enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public int getGender() {
		return this.gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getLastupdatedon() {
		return this.lastupdatedon;
	}

	public void setLastupdatedon(Date lastupdatedon) {
		this.lastupdatedon = lastupdatedon;
	}

	public String getMiddlename() {
		return this.middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public List<Emprole> getEmproles() {
		return this.emproles;
	}

	public void setEmproles(List<Emprole> emproles) {
		this.emproles = emproles;
	}

	public Emprole addEmprole(Emprole emprole) {
		getEmproles().add(emprole);
		emprole.setEmployee(this);

		return emprole;
	}

}