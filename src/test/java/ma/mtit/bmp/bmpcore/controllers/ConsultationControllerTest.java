package ma.mtit.bmp.bmpcore.controllers;

import ma.mtit.bmp.bmpcore.model.Consultation;
import ma.mtit.bmp.bmpcore.service.interfaces.ConsultationService;
import ma.mtit.bmp.bmpcore.utility.TestUtil;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringRunner.class)
public class ConsultationControllerTest {
    @MockBean
    private ConsultationService consultationService;

    private MockMvc mockMvc;

    @Before
    public void SetUp(){
        ConsultationController consultationController = new ConsultationController(consultationService);
        mockMvc = standaloneSetup(consultationController).build();
    }

    @Test
    public void testGetAllConsultation() throws Exception {
        mockMvc.perform(get("/consultation/all"))
                .andExpect(status().isOk());
    }
    @Test
    public  void testAddConsultation() throws Exception{
        Consultation consultation = new Consultation();
        when(consultationService.addConsultation(consultation)).thenReturn(consultation);
        mockMvc.perform(post("/consultation/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.convertObjectToJsonBytes(consultation)))
                .andExpect(status().isCreated());
    }
    @Test
    public void testDeleteConsultation() throws Exception{
        Long id = 1L;
        mockMvc.perform(delete("/consultation/delete/{id}" , id))
                .andExpect(status().isOk());
        verify(consultationService).deleteConsultation(1L);
    }
    @Test
    public void testGetConsultationById() throws Exception{
        Long id = 1L;
        mockMvc.perform(get("/consultation/find/id/{id}", id))
                .andExpect(status().isOk());
        verify(consultationService).findConsultationById(1L);
    }
    @Test
    public void testGetConsultationByObs() throws Exception {
        String observation = "obs";
        mockMvc.perform(get("/consultation/find/observation/{obs}" , observation))
                .andExpect(status().isOk());
        verify(consultationService).findConsultationByObs("obs");
    }
    @Test
    public void testUpdateConsultation() throws Exception {
       Consultation consultation = new Consultation();
        when(consultationService.updateConsultation(consultation)).thenReturn(consultation);
        mockMvc.perform(put("/consultation/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.convertObjectToJsonBytes(consultation)))
                .andExpect(status().isOk());

    }

}
