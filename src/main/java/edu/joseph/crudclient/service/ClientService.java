package edu.joseph.crudclient.service;

import edu.joseph.crudclient.model.Client;
import edu.joseph.crudclient.repository.ClientRepository;
import edu.joseph.crudclient.service.exceptions.ResorceNotFound;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public List<Client> findAll(){
        try{
            return clientRepository.findAll();
        }catch(RuntimeException e) {
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
        }catch (RuntimeException e){
            throw new ResorceNotFound();
        }
    }
}
