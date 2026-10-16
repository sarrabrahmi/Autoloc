package tn.esprit.autoloc.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.Entities.paiement;

@Repository
public interface paiementRepo extends JpaRepository<paiement, Long> {
}
