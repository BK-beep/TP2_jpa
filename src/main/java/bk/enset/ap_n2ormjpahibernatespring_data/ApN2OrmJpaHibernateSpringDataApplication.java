package bk.enset.ap_n2ormjpahibernatespring_data;

import bk.enset.ap_n2ormjpahibernatespring_data.entities.Consultation;
import bk.enset.ap_n2ormjpahibernatespring_data.entities.Medecin;
import bk.enset.ap_n2ormjpahibernatespring_data.entities.Patient;
import bk.enset.ap_n2ormjpahibernatespring_data.entities.RendezVous;
import bk.enset.ap_n2ormjpahibernatespring_data.repositories.ConsultationRepository;
import bk.enset.ap_n2ormjpahibernatespring_data.repositories.MedecinRepository;
import bk.enset.ap_n2ormjpahibernatespring_data.repositories.PatientRepository;
import bk.enset.ap_n2ormjpahibernatespring_data.repositories.RendezVousRepository;
import bk.enset.ap_n2ormjpahibernatespring_data.service.HospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class ApN2OrmJpaHibernateSpringDataApplication {

    public static void main(String[] args){
        SpringApplication.run(ApN2OrmJpaHibernateSpringDataApplication.class, args);
    }

    @Bean //c'est une fonction qui va s'executer au demarrage
    CommandLineRunner start(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository, HospitalService hospitalService){
        return args -> {
            Stream.of("Khaoula","baraka","al jamila","l fena l ghzala","wa Hasssaaaaan")
                    .forEach(name->{
                        Patient patient = new Patient();
                        patient.setName(name);
                        patient.setBirthday(new Date());
                        patient.setSick(false);
                        hospitalService.savePatient(patient);
            });
            Stream.of("Khoukha","bk","jamiuiiiila","fenaGhzala","waHHHHasssaaaaan")
                    .forEach(name->{
                        Medecin medecin = new Medecin();
                        medecin.setName(name);
                        medecin.setMail(name+"@gmail.com");
                        medecin.setSpeciality(Math.random()>0.5?"cardio":"dentiste");
                        hospitalService.saveMedecin(medecin);
                    });
            Patient patient=patientRepository.findById(1L).orElse(null);
            Patient patient1=patientRepository.findByName("Khaoula");
            Medecin medecin=medecinRepository.findByName("Khoukha");
            RendezVous rendezVous=new RendezVous();
            rendezVous.setDateRdv(new Date());
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient);
            hospitalService.saveRendezVous(rendezVous);

            RendezVous rendezVous1=rendezVousRepository.findAll().get(0);
            Consultation consultation=new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapportConsultation("rapport");
            hospitalService.saveConsultation(consultation);
        };
    }

}
