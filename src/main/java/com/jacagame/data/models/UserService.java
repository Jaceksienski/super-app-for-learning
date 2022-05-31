package com.jacagame.data.models;


import com.jacagame.data.token.Token;
import com.jacagame.data.token.TokenRepo;
import com.jacagame.data.MailService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.Map;
import java.util.UUID;

@AllArgsConstructor
@Service
public class UserService {

    private TokenRepo tokenRepo;
    private MailService mailService;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;


    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles("ROLE_USER");
        userRepository.save(user);
        sendToken(user);
    }

    public void getUser(String name) {
        userRepository.findByUserName(name);
    }

    public void getUser(Long id) {
        userRepository.findById(id);
    }

    public String getAllUsers() {
        return userRepository.findAll().toString();
    }

    private void sendToken(User user) {
        String tokenValue = UUID.randomUUID().toString();
        Token token = new Token();
        token.setValue(tokenValue);
        token.setUser(user);
        tokenRepo.save(token);
        String url = "http://localhost:8080/token?value=" + tokenValue;

//        try {
//            mailService.sendMail(user.getUserName(), "Potwierdz",url,false);
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
    }

    public void updateEmail(Long id, Map<String, String> updateEmailMap) {
        this.userRepository.findById(id).get().setEmail(String.valueOf(updateEmailMap));
    }
}

