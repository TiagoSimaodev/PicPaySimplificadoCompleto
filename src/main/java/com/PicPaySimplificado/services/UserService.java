package com.PicPaySimplificado.services;

import com.PicPaySimplificado.domain.user.User;
import com.PicPaySimplificado.domain.user.UserType;
import com.PicPaySimplificado.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        if(sender.getUserType() == UserType.MERCHANT){
            throw new Exception("Usuários do tipo lojista, não está autorizado a realizar transação.");
        }
        if (sender.getBalance().compareTo(amount) > 0){
            throw new Exception("Saldo insuficiente");
        }
    }


    public User findUserById(Long id) throws Exception {
        return  this.repository.findUserById(id).orElseThrow(()-> new Exception("Usuario não encontrado"));
    }
    public void saveUser(User user){
        this.repository.save(user);
    }
}
