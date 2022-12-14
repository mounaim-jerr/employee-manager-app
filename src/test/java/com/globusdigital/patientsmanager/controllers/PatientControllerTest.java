package com.globusdigital.patientsmanager.controllers;

import com.globusdigital.patientsmanager.model.Patient;
import com.globusdigital.patientsmanager.service.interfaces.PatientService;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringRunner.class)
public class PatientControllerTest {
    @MockBean
    private PatientService patientService;
  private MockMvc mockMvc;
    @Before
    public void setUp() {
        PatientController patientController = new PatientController(patientService);
        mockMvc = standaloneSetup(patientController).build();
    }
    @Test
    public void testGetAllPatients() throws Exception {
        mockMvc.perform(get("/patient/all"))
                .andExpect(status().isOk());
    }
    @Test
    public  void testAddPatient() throws Exception{
        Patient patient = new Patient(1L,"patient", "FACIN");
        when(patientService.addPatient(patient)).thenReturn(patient);
        mockMvc.perform(post("/patient/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.convertObjectToJsonBytes(patient)))
                .andExpect(status().isCreated());
    }
    @Test
    public void testDeletePatient() throws Exception{
        Long id = 1L;
        mockMvc.perform(delete("/patient/delete/{id}" , id))
                .andExpect(status().isOk());
        verify(patientService).deletePatient(1L);
    }
}
