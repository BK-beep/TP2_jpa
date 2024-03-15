package bk.enset.ap_n2ormjpahibernatespring_data.repositories;

import bk.enset.ap_n2ormjpahibernatespring_data.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    Medecin findByName(String name);
}
