package com.application.ScienceTeacher.Service;

import com.application.ScienceTeacher.Entity.Client;
import com.application.ScienceTeacher.Entity.User;
import com.application.ScienceTeacher.Exception.ResourceNotFoundException;
import com.application.ScienceTeacher.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {


    @Autowired
    public ClientRepository clientRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    public Client registerClient(Client client) {
        String encPsd = this.passwordEncoder.encode(client.getPassword());
        client.setPassword(encPsd);
        client.setRoles("ROLE_CLIENT".toUpperCase());
        return this.clientRepository.save(client);
    }

    public Client addClient(Client client) {
        String encPsd = this.passwordEncoder.encode(client.getPassword());
        client.setPassword(encPsd);
        return this.clientRepository.save(client);
    }

    public List<Client> getAllClient() {
        return this.clientRepository.findAll();
    }

    public Client getById(Integer id) {
        return (Client) this.clientRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("That" + id + "NotFound"));
    }

    public void deleteClientById(Integer id) {
        this.clientRepository.deleteById(id);
    }

    public Client updateClient(Client client) {
        String encPsd = this.passwordEncoder.encode(client.getPassword());
        client.setPassword(encPsd);
        Client client1 = (Client) this.clientRepository.findById(client.getId()).orElseThrow(null);
        client1.setFirstName(client.getFirstName());
        client1.setLastName(client.getLastName());
        client1.setAge(client.getAge());
        client1.setGender(client.getGender());
        client1.setPhoneNumber(client.getPhoneNumber());
        client1.setEmail(client.getEmail());
        client1.setAddress(client.getAddress());
        client1.setPassword(client.getPassword());
        client1.setUserName(client.getUserName());
        client1.setRoles(client.getRoles());
        client1.setStatus(client.getStatus());

        return this.clientRepository.save(client);
    }
}
