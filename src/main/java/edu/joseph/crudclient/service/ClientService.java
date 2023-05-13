package edu.joseph.crudclient.service;

import edu.joseph.crudclient.model.Client;
import edu.joseph.crudclient.repository.ClientRepository;
import edu.joseph.crudclient.service.exceptions.DatabaseException;
import edu.joseph.crudclient.service.exceptions.ResourceNotFound;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.dao.EmptyResultDataAccessException;
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
            throw new ResourceNotFound();
        }

    }

    @Transactional(readOnly = true)
    public Client findById(Long id){
        Optional<Client> obj = clientRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFound(id));
    }

    @Transactional(readOnly = true)
    public List<Client> findByString(String text){
        try{
            return clientRepository.findByString(text);
        }catch (NullPointerException e ){
            throw new ResourceNotFound();
        }
    }

    @Transactional
    public Client createClient(Client obj){
       try{
           return clientRepository.save(obj);
       } catch (IllegalArgumentException e){
           throw new ResourceNotFound();
       }
    }

    @Transactional
    public void deleteClient(Long id){
        try{
            clientRepository.deleteById(id);
        }catch (EmptyResultDataAccessException | IllegalArgumentException e){
            throw new ResourceNotFound(id);
        }catch (EntityNotFoundException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    @Transactional
    public Client updateClient(Long id, Client obj){
        try{
            var entity = clientRepository.getReferenceById(id);
            updateData(entity, obj);
            return clientRepository.save(entity);
        }catch (EntityNotFoundException | IllegalArgumentException e) {
            throw new ResourceNotFound(id);
        }
    }

    private void updateData(Client entity, Client client){
        entity.setName(client.getName());
        entity.setSalary(client.getSalary());
        entity.setChildren(client.getChildren());
        entity.setBirthDate(client.getBirthDate());
    }
}
