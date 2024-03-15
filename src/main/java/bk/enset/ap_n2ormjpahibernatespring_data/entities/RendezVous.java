package bk.enset.ap_n2ormjpahibernatespring_data.entities;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class RendezVous {
    @Id
    private String  id;
    @ManyToOne
    private Medecin medecin;
    @ManyToOne
    private Patient patient;
    @OneToOne
    private Consultation consultation;
    private Date dateRdv;
    private Date heureRdv;

}
