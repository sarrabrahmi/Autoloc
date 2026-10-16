package tn.esprit.autoloc.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.client;
import tn.esprit.autoloc.Repositories.clientRepo;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ClientService implements IClientService {
    private final clientRepo clientRepo;

    @Override
    public client ajouterClient(client cl) { return clientRepo.save(cl); }
    @Override
    public void supprimerClient(long idClient) { clientRepo.deleteById(idClient); }
    @Override
    public List<client> recupererClients() { return clientRepo.findAll(); }
    @Override
    public Set<client> findClients() { return new HashSet<>(clientRepo.findAll()); }
    @Override
    public client recupererClientByid(long idClient) { return clientRepo.findById(idClient).orElse(null); }
}