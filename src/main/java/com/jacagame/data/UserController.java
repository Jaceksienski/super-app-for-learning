package com.jacagame.data;

import com.jacagame.data.models.UserService;
import com.jacagame.data.player.PlayerService;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@AllArgsConstructor
@RestController
@RequestMapping(path = "action/v1/user")
public class UserController {

    UserService userService;
    PlayerService playerService;

    @GetMapping
    public void findUser(@RequestParam Long id) {
        userService.getUser(id);
    }

    @GetMapping(path = "/all")
    public void findAllUsers() {
        userService.getAllUsers();
        Logger LOGGER = LogManager.getLogger();
        LOGGER.log(Level.INFO, "USERS: " + userService.getAllUsers());
    }

    @PatchMapping(path = {"userId"})
    public void updateUserEmail(@RequestBody Map<String, String> updateEmailMap, @PathVariable Long id) {
        userService.updateEmail(id, updateEmailMap);
    }


}
