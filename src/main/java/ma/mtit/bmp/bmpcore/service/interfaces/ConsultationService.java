package ma.mtit.bmp.bmpcore.service.interfaces;

import ma.mtit.bmp.bmpcore.model.Consultation;

import java.util.List;

public interface ConsultationService {
    Consultation addConsultation(Consultation consultation);
    void deleteConsultation(Long id);
    Consultation updateConsultation(Consultation consultation);
    Consultation findConsultationById(Long id);
    List<Consultation> findConsultationByObs(String obs);
    List<Consultation> findAllConsultation();
}
