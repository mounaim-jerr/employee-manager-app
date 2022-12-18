package com.globusdigital.patientsmanager.controllers;

import com.globusdigital.patientsmanager.model.Department;
import com.globusdigital.patientsmanager.service.interfaces.DepartmentServices;
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
public class DepartmentControllerTest {
    @MockBean
    private DepartmentServices departmentServices;
    private MockMvc mockMvc;
    @Before
    public void setUp(){
        DepartmentController departmentController = new DepartmentController(departmentServices);
        mockMvc = standaloneSetup(departmentController).build();
    }
    @Test
    public void testGetAllDepartment() throws Exception {
        mockMvc.perform(get("/department/all"))
                .andExpect(status().isOk());
    }
    @Test
    public  void testAddDepartment() throws Exception{
        Department department = new Department();
        department.setDepartmentName("department");
        when(departmentServices.addDepartment(department)).thenReturn(department);
        mockMvc.perform(post("/department/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.convertObjectToJsonBytes(department)))
                .andExpect(status().isCreated());
    }
    @Test
    public void testDeleteDepartment() throws Exception{
        Long id = 1L;
        mockMvc.perform(delete("/department/delete/{id}" , id))
                .andExpect(status().isOk());
        verify(departmentServices).deleteDepartment(1L);
    }
    @Test
    public void testGetDepartmentById() throws Exception{
        Long id = 1L;
        mockMvc.perform(get("/department/find/id/{id}", id))
                .andExpect(status().isOk());
        verify(departmentServices).findDepartmentById(1L);
    }
    @Test
    public void testGetDepartmentByName() throws Exception {
        String name = "name";
        mockMvc.perform(get("/department/find/name/{name}" , name))
                .andExpect(status().isOk());
        verify(departmentServices).findDepartmentByName("name");
    }
    @Test
    public void testUpdateDepartment() throws Exception {
        Department department = new Department();
        department.setDepartmentName("department");
        when(departmentServices.updateDepartment(department)).thenReturn(department);
        mockMvc.perform(put("/department/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.convertObjectToJsonBytes(department)))
                .andExpect(status().isOk());

    }
}
