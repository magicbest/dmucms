package com.safewind.dmucms.domain;

import java.io.Serializable;

public class Team  implements Serializable{

    private static final long serialVersionUID = -7771526514885245854L;
    
    private Integer project_Id ;
	private String  student_Id;
	private String  student_role;
	public Integer getProject_Id() {
		return project_Id;
	}
	public void setProject_Id(Integer project_Id) {
		this.project_Id = project_Id;
	}
	public String getStudent_Id() {
		return student_Id;
	}
	public void setStudent_Id(String student_Id) {
		this.student_Id = student_Id;
	}
	public String getStudent_role() {
		return student_role;
	}
	public void setStudent_role(String student_role) {
		this.student_role = student_role;
	}
	public Team(Integer project_Id, String student_Id, String student_role) {
		super();
		this.project_Id = project_Id;
		this.student_Id = student_Id;
		this.student_role = student_role;
	}
	
	
}
