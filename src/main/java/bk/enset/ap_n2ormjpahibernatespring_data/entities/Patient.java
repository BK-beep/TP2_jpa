package bk.enset.ap_n2ormjpahibernatespring_data.entities;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date birthday;
    private Boolean sick;
    private int score;
    @OneToMany(mappedBy = "patient" , fetch= FetchType.LAZY)
    private List<RendezVous> rendezVous;
}
