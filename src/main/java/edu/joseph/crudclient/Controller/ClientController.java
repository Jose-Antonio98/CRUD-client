package edu.joseph.crudclient.Controller;

import edu.joseph.crudclient.model.Client;
import edu.joseph.crudclient.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> findAllClients() {
        List<Client> allClients = clientService.findAll();
        return ResponseEntity.ok().body(allClients);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(clientService.findById(id));
    }

    @GetMapping(value = "/search/{text}")
    public ResponseEntity<List<Client>> findByString(@PathVariable("text") String text) {
        List<Client> searchClient = clientService.findByString(text);
        return ResponseEntity.ok().body(searchClient);
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client obj) {
        obj = clientService.createClient(obj);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client obj) {
        obj = clientService.updateClient(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
