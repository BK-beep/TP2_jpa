package bk.enset.ap_n2ormjpahibernatespring_data.repositories;

import bk.enset.ap_n2ormjpahibernatespring_data.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findByName(String name);
}
