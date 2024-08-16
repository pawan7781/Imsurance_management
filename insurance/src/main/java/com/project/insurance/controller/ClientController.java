package com.project.insurance.controller;

import com.project.insurance.model.ApiResponse;
import com.project.insurance.model.Claim;
import com.project.insurance.model.Client;
import com.project.insurance.service.ClaimService;
import com.project.insurance.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping("saveClient/{insurancePolicyId}")
    public ApiResponse<Client> saveClient(@RequestBody Client client, @PathVariable int insurancePolicyId) {
       return clientService.insertClient( insurancePolicyId, client);
    }
    @GetMapping("getByClientId/{clientId}")
    public ApiResponse<Client> getByClientId(@PathVariable int clientId) {

        return clientService.getByClientId(clientId);
    }
    @DeleteMapping("deleteClient/{clientId}")
    public ApiResponse<Client> deleteClient(@PathVariable int clientId)
    {
        return clientService.deleteClient(clientId);
    }
    @PutMapping("updateClient/{clientId}")
    public ApiResponse<Client> updateClient(@RequestBody Client client)
    {
        return clientService.updateClient(client);
    }
    @GetMapping("/displayAllClient")
    public ApiResponse<List<Client>> displayAllClient()
    {
        return clientService.displayAllClients();
    }
}
