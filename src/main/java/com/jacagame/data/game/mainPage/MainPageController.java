package com.jacagame.data.game.mainPage;

import com.jacagame.data.models.User;
import com.jacagame.data.models.UserService;
import com.jacagame.data.player.Player;
import com.jacagame.data.player.PlayerService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;


@Controller
public class MainPageController {

    @Autowired
    UserService userService;
    @Autowired
    PlayerService playerService;

    @GetMapping("game/main")
    public String main(Model model, Authentication authentication) {
        Logger LOGGER = LogManager.getLogger();

        User u = userService.getUser(authentication.getName());
        Optional<Player> player = playerService.getPlayerById(u.getId());
        LOGGER.log(Level.INFO, "Player: " + player.toString());
        model.addAttribute("player", player.get());
        return ("gameUi/main.html");
    }


}
