package comLesson54.controller;


import comLesson54.entity.User;
import comLesson54.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private AuthenticationManager authenticationManager;


    public String registerUser(@RequestBody RequestDTO registrationRequest) {
        User user = new User();

        user.setPassword(registrationRequest.getPassword());
        user.setName(registrationRequest.getLogin());
        userService.save(user);
        return "OK";
    }

}
