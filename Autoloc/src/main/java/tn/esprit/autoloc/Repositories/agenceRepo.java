package tn.esprit.autoloc.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.Entities.agence;

@Repository
public interface agenceRepo extends JpaRepository<agence, Long> {
}