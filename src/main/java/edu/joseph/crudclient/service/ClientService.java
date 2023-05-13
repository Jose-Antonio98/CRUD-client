package edu.joseph.crudclient.service;

import edu.joseph.crudclient.model.Client;
import edu.joseph.crudclient.repository.ClientRepository;
import edu.joseph.crudclient.service.exceptions.ResorceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public List<Client> findAll(){
        try{
            return clientRepository.findAll();
        }catch (NullPointerException e){
            throw new ResorceNotFound();
        }

    }

    @Transactional(readOnly = true)
    public Client findById(Long id){
        Optional<Client> obj = clientRepository.findById(id);
        return obj.orElseThrow(() -> new ResorceNotFound(id));
    }

    @Transactional(readOnly = true)
    public List<Client> findByString(String text){
        try{
            return clientRepository.findByString(text);
        }catch (NullPointerException e){
            throw new ResorceNotFound();
        }
    }
}
