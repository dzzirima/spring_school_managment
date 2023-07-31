package black.auth.controller;


import black.auth.model.User;
import black.auth.service.UserServiceImpl;
import black.events.RegistrationCompleteEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class RegistrationController {



    private UserServiceImpl userService;
    private ApplicationEventPublisher publisher;

    public RegistrationController(
            UserServiceImpl userService,
            ApplicationEventPublisher publisher) {
        this.userService = userService;
        this.publisher = publisher;
    }

    @PostMapping("/register")
    public String registerUser(
            @RequestBody User userModel
            ){
        User user = userService.registerUser(userModel);

        publisher.publishEvent(new RegistrationCompleteEvent(
                user ,
                "url"
        ));
        return  "Success";
    }
}
