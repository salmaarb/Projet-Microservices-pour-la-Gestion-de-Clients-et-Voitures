package org.ensaj.client.Controller;
import org.ensaj.client.Model.Client;
import org.ensaj.client.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class ClientController {


    @Autowired
    ClientService clientService;




    @GetMapping("/clients")
    public List<Client> chercherClient(){
        return clientService.retournerListeClients();
    }

    @GetMapping("/clients/{id}")
    public Client chercherUnClient(@PathVariable Long id) throws Exception {
        return clientService.retournerClientById(id);
    }

    @PostMapping("/clients")
    public Client enregistrerUnClient(@RequestBody Client client){
        return clientService.enregistrerClient(client);
    }

    @PutMapping("/clients/{id}")
    public ResponseEntity<Client> modifierUnClient(@PathVariable Long id, @RequestBody Client client) throws Exception {
        return clientService.modifierClient(id, client);
    }

    @DeleteMapping("/clients/{id}")
    public void deleteUnClient(@PathVariable Long id){
        clientService.supprimerClient(id);
    }


}
