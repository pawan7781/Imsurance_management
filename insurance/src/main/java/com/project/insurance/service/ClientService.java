package com.project.insurance.service;

import com.project.insurance.dao.ClientDao;
import com.project.insurance.dao.InsurancePolicyDao;
import com.project.insurance.model.ApiResponse;
import com.project.insurance.model.Claim;
import com.project.insurance.model.Client;
import com.project.insurance.model.InsurancePolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ClientService {
    @Autowired
    private InsurancePolicyDao insurancePolicyDao;
    @Autowired
    private ApiResponse<Client> clientResponse;
    @Autowired
    private ClientDao clientDao;
    @Autowired
    private ApiResponse<List<Client>> findAllClaimResponse;

    public ApiResponse<Client> insertClient(int insurancePolicyId, Client client) {
        InsurancePolicy insurancePolicy=insurancePolicyDao.getByInsurancePolicyId(insurancePolicyId);
        if(Objects.isNull(insurancePolicy)){
            clientResponse.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
            clientResponse.setMsg("Data not saved");
            clientResponse.setData(null);
        }
        else
        {
            client.setInsurancePolicy(insurancePolicy);
            clientDao.insertClient(client);

            clientResponse.setStatusCode(HttpStatus.ACCEPTED.value());
            clientResponse.setMsg("Data saved ");
            clientResponse.setData(client);

        }
        return clientResponse;

    }
    public ApiResponse<Client>getByClientId(int clientId)
    {
        Client client = clientDao.getByClientId(clientId);
        if(Objects.isNull(client))
        {
            throw new RuntimeException("claim details not found");
        }
        else
        {
            clientResponse.setStatusCode(HttpStatus.ACCEPTED.value());
            clientResponse.setMsg("client existed");
            clientResponse.setData(client);
        }
        return clientResponse;
    }
    public ApiResponse<Client> deleteClient(int clientId)
    {
        Client client =clientDao.deleteClient(clientId);
        if(Objects.isNull(client))
        {
            throw new RuntimeException("claim details not found");
        }
        else
        {
            clientResponse.setStatusCode(HttpStatus.FOUND.value());
            clientResponse.setMsg("client deleted successfully");
            clientResponse.setData(client);
        }
        return clientResponse;
    }
    public ApiResponse<Client> updateClient( Client client) {
        Client updateClient=clientDao.getByClientId(client.getClientId());
        if(Objects.isNull(updateClient))
        {
            throw new RuntimeException("claim details not found");
        }
        updateClient.setClientName(client.getClientName());
        updateClient.setClientAddress(client.getClientAddress());
        updateClient.setClientContactInformation(client.getClientContactInformation());
        updateClient.setClientDateOfBirth(client.getClientDateOfBirth());


        clientResponse.setStatusCode(HttpStatus.ACCEPTED.value());
        clientResponse.setMsg("Data updated");
        clientResponse.setData(updateClient);

        return clientResponse;
    }
    public ApiResponse<List<Client>> displayAllClients ()
    {
        List<Client> client=clientDao.displayAllClients();
        if(Objects.isNull(client))
        {
            findAllClaimResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
            findAllClaimResponse.setMsg("client details are not available");
            findAllClaimResponse.setData(null);
        }
        findAllClaimResponse.setStatusCode(HttpStatus.FOUND.value());
        findAllClaimResponse.setMsg("Client details available");
        findAllClaimResponse.setData(client);


        return findAllClaimResponse;
    }


}
