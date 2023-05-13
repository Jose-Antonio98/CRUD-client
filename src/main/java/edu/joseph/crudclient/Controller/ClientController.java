package edu.joseph.crudclient.Controller;

import edu.joseph.crudclient.model.Client;
import edu.joseph.crudclient.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> findAllClients(){
        List<Client> allClients = clientService.findAll();
        return ResponseEntity.ok().body(allClients);
    }
}
