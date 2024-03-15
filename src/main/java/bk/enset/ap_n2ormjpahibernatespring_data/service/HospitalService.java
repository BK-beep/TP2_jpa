package bk.enset.ap_n2ormjpahibernatespring_data.service;

import bk.enset.ap_n2ormjpahibernatespring_data.entities.Consultation;
import bk.enset.ap_n2ormjpahibernatespring_data.entities.Medecin;
import bk.enset.ap_n2ormjpahibernatespring_data.entities.Patient;
import bk.enset.ap_n2ormjpahibernatespring_data.entities.RendezVous;
import bk.enset.ap_n2ormjpahibernatespring_data.repositories.ConsultationRepository;
import bk.enset.ap_n2ormjpahibernatespring_data.repositories.MedecinRepository;
import bk.enset.ap_n2ormjpahibernatespring_data.repositories.PatientRepository;
import bk.enset.ap_n2ormjpahibernatespring_data.repositories.RendezVousRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class HospitalService implements IHospitalService{
    private MedecinRepository medecinRepository;
    private PatientRepository patientRepository;
    private ConsultationRepository consultationRepository;
    private RendezVousRepository rendezVousRepository;

    public HospitalService(MedecinRepository medecinRepository, PatientRepository patientRepository, ConsultationRepository consultationRepository, RendezVousRepository rendezVousRepository) {
        this.medecinRepository = medecinRepository;
        this.patientRepository = patientRepository;
        this.consultationRepository = consultationRepository;
        this.rendezVousRepository = rendezVousRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
