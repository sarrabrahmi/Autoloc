package tn.esprit.autoloc.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.Entities.vehicule;

@Repository
public interface vehiculeRepo extends JpaRepository<vehicule, Long> {
}