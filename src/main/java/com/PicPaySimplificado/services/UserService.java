package com.PicPaySimplificado.services;

import com.PicPaySimplificado.domain.user.User;
import com.PicPaySimplificado.domain.user.UserType;
import com.PicPaySimplificado.dtos.UserDTO;
import com.PicPaySimplificado.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

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

    public User createUser(UserDTO data){
        User newUser = new User(data);
        this.saveUser(newUser);
        return newUser;
    }

    public List<User> getAllUsers(){
      return this.repository.findAll();
    }

    public void saveUser(User user){
        this.repository.save(user);
    }
}
