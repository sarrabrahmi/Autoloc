package tn.esprit.autoloc.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.agence;
import tn.esprit.autoloc.Repositories.agenceRepo;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class AgenceService implements IAgenceService {
    private final agenceRepo agenceRepo;

    @Override
    public agence ajouterAgence(agence ag) { return agenceRepo.save(ag); }
    @Override
    public void supprimerAgence(long idAgence) { agenceRepo.deleteById(idAgence); }
    @Override
    public List<agence> recupererAgences() { return agenceRepo.findAll(); }
    @Override
    public Set<agence> findAgences() { return new HashSet<>(agenceRepo.findAll()); }
    @Override
    public agence recupererAgenceByid(long idAgence) { return agenceRepo.findById(idAgence).orElse(null); }
}