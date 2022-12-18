package com.globusdigital.patientsmanager.controllers;

import com.globusdigital.patientsmanager.model.Department;
import com.globusdigital.patientsmanager.model.Doctor;
import com.globusdigital.patientsmanager.model.Speciality;
import com.globusdigital.patientsmanager.service.interfaces.DoctorService;
import com.globusdigital.patientsmanager.utility.TestUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringRunner.class)
public class DoctorControllerTest {
   @MockBean
    private DoctorService doctorService;
    private MockMvc mockMvc;
    @Before
            public void setUp(){
        DoctorControllers doctorControllers = new DoctorControllers(doctorService);
        mockMvc = standaloneSetup(doctorControllers).build();
    }
    @Test
    public void testGetAllDoctors() throws Exception {
        mockMvc.perform(get("/doctor/all"))
                .andExpect(status().isOk());
    }
    @Test
    public  void testAddDoctor() throws Exception{
        Department department = new Department();
        department.setDepartmentName("department");
        Speciality speciality = new Speciality();
        speciality.setSpecialityName("speciality");
        speciality.setDepartmentOfTheSpeciality(department);
        Doctor doctor = new Doctor();
        doctor.setDoctorName("doctor");
        doctor.setSpecialityOfDoctor(speciality);

        when(doctorService.addDoctor(doctor)).thenReturn(doctor);
        mockMvc.perform(post("/doctor/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.convertObjectToJsonBytes(doctor)))
                .andExpect(status().isCreated());
    }
    @Test
    public void testDeleteDoctor() throws Exception{
        Long id = 1L;
        mockMvc.perform(delete("/doctor/delete/{id}" , id))
                .andExpect(status().isOk());
        verify(doctorService).deleteDoctor(1L);
    }
    @Test
    public void testGetDoctorById() throws Exception{
        Long id = 1L;
        mockMvc.perform(get("/doctor/find/id/{id}", id))
                .andExpect(status().isOk());
        verify(doctorService).findDoctorById(1L);
    }
    @Test
    public void testGetDoctorByName() throws Exception {
        String name = "name";
        mockMvc.perform(get("/doctor/find/name/{name}" , name))
                .andExpect(status().isOk());
        verify(doctorService).findDoctorByName("name");
    }
    @Test
    public void testUpdateDoctor() throws Exception {
        Department department = new Department();
        department.setDepartmentName("department");
        Speciality speciality = new Speciality();
        speciality.setSpecialityName("speciality");
        speciality.setDepartmentOfTheSpeciality(department);
        Doctor doctor = new Doctor();
        doctor.setDoctorName("doctor");
        doctor.setSpecialityOfDoctor(speciality);
        when(doctorService.updateDoctor(doctor)).thenReturn(doctor);
        mockMvc.perform(put("/doctor/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.convertObjectToJsonBytes(doctor)))
                .andExpect(status().isOk());

    }
}
