package tn.esprit.autoloc.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.Entities.client;

@Repository
public interface clientRepo extends JpaRepository<client, Long> {
    boolean existsByEmail(String email);
}