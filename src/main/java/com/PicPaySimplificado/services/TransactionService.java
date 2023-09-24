package com.PicPaySimplificado.services;

import com.PicPaySimplificado.domain.user.User;
import com.PicPaySimplificado.dtos.TransactionDTO;
import com.PicPaySimplificado.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class TransactionService {
    @Autowired
    private UserService userService;
    @Autowired
    private TransactionRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    public void createTransaction(TransactionDTO transaction) throws Exception {
        User sender = this.userService.findUserById(transaction.senderId());
        User receiver = this.userService.findUserById(transaction.receiverId());

        userService.validateTransaction(sender, transaction.value());

        if ()
    }
    public boolean authorizeTransaction(User sender, BigDecimal value){
       ResponseEntity<Map>authorizationResponse = restTemplate.getForEntity("https://run.mocky.io/v3/8fafdd68-a090-496f-8c9a-3442cf30dae6https://run.mocky.io/v3/8fafdd68-a090-496f-8c9a-3442cf30dae6" Map.class)

    }
}
