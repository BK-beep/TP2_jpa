package bk.enset.ap_n2ormjpahibernatespring_data.repositories;

import bk.enset.ap_n2ormjpahibernatespring_data.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
