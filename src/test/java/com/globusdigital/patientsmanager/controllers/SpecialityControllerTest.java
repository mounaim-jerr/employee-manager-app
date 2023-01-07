package com.globusdigital.patientsmanager.controllers;

import com.globusdigital.patientsmanager.model.Department;
import com.globusdigital.patientsmanager.model.Speciality;
import com.globusdigital.patientsmanager.service.interfaces.SpecialityService;
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
public class SpecialityControllerTest {
    @MockBean
    private SpecialityService specialityService;
    private MockMvc mockMvc;

    @Before
    public void setUp(){
        SpecialityController specialityController = new SpecialityController(specialityService);
        mockMvc = standaloneSetup(specialityController).build();
    }
    @Test
    public void testGetAllSpecialities() throws Exception {
        mockMvc.perform(get("/speciality/all"))
                .andExpect(status().isOk());
    }
    @Test
    public  void testAddSpeciality() throws Exception{
        Department department = new Department();
        department.setName("department");
        Speciality speciality = new Speciality();
        speciality.setName("speciality");
        speciality.setDepartment(department);

        when(specialityService.addSpeciality(speciality)).thenReturn(speciality);
        mockMvc.perform(post("/speciality/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.convertObjectToJsonBytes(speciality)))
                .andExpect(status().isCreated());
    }
    @Test
    public void testDeleteSpeciality() throws Exception{
        Long id = 1L;
        mockMvc.perform(delete("/speciality/delete/{id}" , id))
                .andExpect(status().isOk());
        verify(specialityService).deleteSpeciality(1L);
    }
    @Test
    public void testGetSpecialityById() throws Exception{
        Long id = 1L;
        mockMvc.perform(get("/speciality/find/id/{id}", id))
                .andExpect(status().isOk());
        verify(specialityService).findSpecialityById(1L);
    }
    @Test
    public void testGetSpecialityByName() throws Exception {
        String name = "name";
        mockMvc.perform(get("/speciality/find/name/{name}" , name))
                .andExpect(status().isOk());
        verify(specialityService).findSpecialityByName("name");
    }
    @Test
    public void testUpdateSpeciality() throws Exception {
        Department department = new Department();
        department.setName("department");
        Speciality speciality = new Speciality();
        speciality.setName("speciality");
        speciality.setDepartment(department);
        when(specialityService.updateSpeciality(speciality)).thenReturn(speciality);
        mockMvc.perform(put("/speciality/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.convertObjectToJsonBytes(speciality)))
                .andExpect(status().isOk());

    }
}
