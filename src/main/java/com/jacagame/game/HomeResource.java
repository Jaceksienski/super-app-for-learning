package com.jacagame.game;

import com.jacagame.game.models.User;
import com.jacagame.game.models.UserRepository;
import com.jacagame.game.models.UserService;
import com.jacagame.game.token.Token;
import com.jacagame.game.token.TokenRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Optional;


@Controller
public class HomeResource {

    private UserService userService;
    private UserRepository userRepository;
    private TokenRepo tokenRepo;

    public HomeResource(UserService userService, UserRepository userRepository, TokenRepo tokenRepo) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.tokenRepo = tokenRepo;
    }

    @GetMapping("/user")
    public String user() {
        return ("hello-user.html");
    }

    @GetMapping("/admin")
    public String admin() {
        return ("hello-admin.html");
    }

    @GetMapping("/sign-up")
    public String signup(Model model) {
        model.addAttribute("user", new User());
        return ("sign-up");
    }

    @PostMapping("/register")
    public String register(User user) {
        userService.addUser(user);
        return ("sign-up");
    }

    @GetMapping("/hello")
    public String hello(Principal principal, Model model) {
        model.addAttribute("name", principal.getName());
        return ("hello.html");
    }

    @GetMapping("/token")
    public String token(@RequestParam String value) {
        Optional<Token> byValue = tokenRepo.findByValue(value);
        User user = byValue.get().getUser();
        user.setActive(true);
        userRepository.save(user);

        return ("hello.html");
    }


}
