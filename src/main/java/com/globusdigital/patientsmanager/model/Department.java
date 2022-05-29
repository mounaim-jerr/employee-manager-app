package com.globusdigital.patientsmanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String departmentAdmin ;
    private String getDepartmentPassword;

    public Department() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentAdmin() {
        return departmentAdmin;
    }

    public void setDepartmentAdmin(String departmentAdmin) {
        this.departmentAdmin = departmentAdmin;
    }

    public String getGetDepartmentPassword() {
        return getDepartmentPassword;
    }

    public void setGetDepartmentPassword(String getDepartmentPassword) {
        this.getDepartmentPassword = getDepartmentPassword;
    }
}
