package bk.enset.ap_n2ormjpahibernatespring_data.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity @Data
public class Consultation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateConsultation;
    private String rapportConsultation;
    @OneToOne(mappedBy = "consultation" , fetch = FetchType.LAZY)
    private RendezVous rendezVous;
}
