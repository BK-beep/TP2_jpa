package bk.enset.ap_n2ormjpahibernatespring_data.service;

import bk.enset.ap_n2ormjpahibernatespring_data.entities.Consultation;
import bk.enset.ap_n2ormjpahibernatespring_data.entities.Medecin;
import bk.enset.ap_n2ormjpahibernatespring_data.entities.Patient;
import bk.enset.ap_n2ormjpahibernatespring_data.entities.RendezVous;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRendezVous(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);

}
