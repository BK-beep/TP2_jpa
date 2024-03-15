package bk.enset.ap_n2ormjpahibernatespring_data.entities;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.persistence.Id;

import java.util.List;

@Entity @Data
public class Medecin {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String  name;
    private String mail;
    private String speciality;
    @OneToMany(mappedBy = "medecin" , fetch = FetchType.LAZY)
    List<RendezVous> rendezVous;
}
