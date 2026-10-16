package tn.esprit.autoloc.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.contrat;
import tn.esprit.autoloc.Repositories.contratRepo;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ContratService implements IContratService {
    private final contratRepo contratRepo;

    @Override
    public contrat ajouterContrat(contrat ct) { return contratRepo.save(ct); }
    @Override
    public void supprimerContrat(long idContrat) { contratRepo.deleteById(idContrat); }
    @Override
    public List<contrat> recupererContrats() { return contratRepo.findAll(); }
    @Override
    public Set<contrat> findContrats() { return new HashSet<>(contratRepo.findAll()); }
    @Override
    public contrat recupererContratByid(long idContrat) { return contratRepo.findById(idContrat).orElse(null); }
}