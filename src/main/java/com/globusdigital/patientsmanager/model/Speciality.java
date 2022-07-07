package com.globusdigital.patientsmanager.model;

import javax.persistence.*;

@Entity
public class Speciality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String specialityName;
    @OneToOne
   @JoinColumn(nullable = false)
    private Department departmentOfTheSpeciality;

    public Speciality() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecialityName() {
        return specialityName;
    }

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }

    public Department getDepartmentOfTheSpeciality() {
        return departmentOfTheSpeciality;
    }

    public void setDepartmentOfTheSpeciality(Department departmentOfTheSpeciality) {
        this.departmentOfTheSpeciality = departmentOfTheSpeciality;
    }
}
