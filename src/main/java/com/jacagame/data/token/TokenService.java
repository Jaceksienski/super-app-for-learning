package com.jacagame.data.token;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class TokenService {
    @Autowired
    TokenRepo tokenRepo;

    public Token findToken(String token) throws Exception {
        Optional<Token> token1 = tokenRepo.findByValue(token);
        token1.orElseThrow(() -> new Exception("token not found"));
        return token1.get();
    }
}


