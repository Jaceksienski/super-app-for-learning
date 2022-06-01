package com.jacagame.data.player;


import com.jacagame.data.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PlayerService {


    private PlayerRepository playerRepository;

    public void addPlayer(User user) {
        playerRepository.save(new Player(user));
    }

    public Optional<Player> getPlayerById(Long id) {

        return playerRepository.findById(id);
    }
}
