package com.jacagame.data;

import com.jacagame.data.models.User;
import com.jacagame.data.models.UserRepository;
import com.jacagame.data.models.UserService;
import com.jacagame.data.token.Token;
import com.jacagame.data.token.TokenRepo;
import com.jacagame.data.player.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@AllArgsConstructor
@Controller
public class RegistrationController {

    private UserService userService;
    private UserRepository userRepository;
    private TokenRepo tokenRepo;
    private PlayerService playerService;


    @GetMapping("/sign-up")
    public String signup(Model model) {
        User u = new User();
        model.addAttribute("user", u);
        return ("registration/sign-up");
    }

    @PostMapping("/register")
    public String register(User user) {
        userService.addUser(user);
        playerService.addPlayer(user);
        return ("registration/endregister");
    }


    @GetMapping("/token")
    public String token(@RequestParam String value) {
        Optional<Token> byValue = tokenRepo.findByValue(value);
        User user = byValue.get().getUser();
        user.setActive(true);
        userRepository.save(user);

        return ("main.html");
    }


}
