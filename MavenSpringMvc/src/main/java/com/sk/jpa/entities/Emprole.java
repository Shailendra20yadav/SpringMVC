package com.sk.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the EMPROLES database table.
 * 
 */
@Entity
@Table(name="EMPROLES")
@NamedQuery(name="Emprole.findAll", query="SELECT e FROM Emprole e")
public class Emprole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name="TABLE_GEN", table="SEQUENCE_TABLE", pkColumnName="SEQ_NAME",
    valueColumnName="SEQ_COUNT", pkColumnValue="EMPROLES")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="TABLE_GEN")
	@Column(name="EMPROLE_ID")
	private long emproleId;

	private String rolename;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="EMPLOYEE_ID")
	private Employee employee;

	public Emprole() {
	}

	public long getEmproleId() {
		return this.emproleId;
	}

	public void setEmproleId(long emproleId) {
		this.emproleId = emproleId;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}