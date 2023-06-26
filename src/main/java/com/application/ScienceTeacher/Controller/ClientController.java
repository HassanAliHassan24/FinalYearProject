package com.application.ScienceTeacher.Controller;

import com.application.ScienceTeacher.Entity.Client;
import com.application.ScienceTeacher.Repository.ClientRepository;
import com.application.ScienceTeacher.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin
public class ClientController {

    @Autowired
    public ClientService clientService;

    @Autowired
    public ClientRepository clientRepository;

    @PostMapping("/register")
    public Client registerClient(@RequestBody Client client){
//        LocalDate dob = client.getDob();
        return this.clientService.registerClient(client);
    }
    @PostMapping("/add")
    public Client addClient(@RequestBody Client client){
//        LocalDate dob = client.getDob();
        return this.clientService.addClient(client);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Client>> getAllClient() {
        List<Client> clients = this.clientService.getAllClient();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id") Integer id){
        Client client = this.clientService.getById(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/deleteClient/{id}")
    public void deleteClientById(@PathVariable Integer id){
        this.clientService.deleteClientById(id);
    }
    @PutMapping("updateClient/{id}")
    public Client updateClient(@RequestBody Client client){
        return this.clientService.updateClient(client);
    }

}
