package com.beyondbanking.ssh.financialoverviewservice.controllers;


import com.beyondbanking.ssh.financialoverviewservice.model.dto.Transactions;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(path = "/v1/transactions")
public class TransactionsController {


    private Object getResponse(String uri, Class object) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Authorization", "DirectLogin token=" + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyIiOiIifQ.Y9djraiiTmBz1O6INxhESMpDlFvsHdxa-4Skd4IOQJw");
        // headers.set("Host", "127.0.0.1:8080");
        headers.set("Connection", "close");
        headers.set("User-Agent", "Paw/2.3.3 (Macintosh; OS X/10.11.3) GCDHTTPRequest");
        headers.set("Content-Length", "0");
        HttpEntity<?> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity exchange = restTemplate.exchange(uri, HttpMethod.GET, entity, object);
        return exchange.getBody();
    }

    @RequestMapping(method = RequestMethod.GET)
    @CrossOrigin
    public Transactions getTransactions(
            @RequestParam(value = "accountID", required = true) String accountID) {

        String obpTransactions = "https://beyondbanking.openbankproject.com/obp/v3.0.0/banks/bb.01.nl.nl/accounts/MyAccount/owner/transactions";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(obpTransactions).queryParam("ACCOUNT_ID", accountID);
        return (Transactions) getResponse(builder.build().encode().toString(), Transactions.class);

    }

}