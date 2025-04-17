package crud;

import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HelloController {

    @Value("${welcome.massage}")
    private String massage; // лучше переименовать в message

    @GetMapping("/test")
    public String getMassage(Model model) {
        model.addAttribute("welcome", massage);
        return "hello";
    }
    @PostMapping
    public String createPerson(@Valid Peron peron, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            if (bindingResult.hasFieldErrors("id")){
                System.out.println("error");
            }
            return "hello";
        }

        System.out.println(peron);

        return "createPerson";
    }
}