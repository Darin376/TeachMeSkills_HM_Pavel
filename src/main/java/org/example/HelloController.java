package org.example;

import crud.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import users.User;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Controller

@RequestMapping("/hello")
public class HelloController {
    private UserRepository userRepository;

    @RequestMapping("/page")
    public String page() {         //можно в скобках указать имя параметра

        return "responseForm";
    }

    @GetMapping("/show-users")
    public String create1(Model model) throws SQLException {
        userRepository = new UserRepository();
        List<User> allUsers = userRepository.getAllUsers();
        model.addAttribute("all_users", allUsers);
        return "showUser";
    }

    private void validateIdParam(String idParam) {
        if (idParam == null || idParam.isEmpty()) {
            throw new IllegalArgumentException("ID parameter is missing or empty");
        }

        // Дополнительная проверка на число (если нужно)
        if (!idParam.matches("\\d+")) {
            throw new IllegalArgumentException("ID must be a number");
        }
    }

    @PostMapping("/show-users")
    public String deleteUser(
            @RequestParam("id") String idParam,
            Model model,
            HttpServletRequest request
    ) {
        try {
            validateIdParam(idParam);
            int idUser = Integer.parseInt(idParam);
            userRepository.deleteUser(idUser);
            return "redirect:/hello/show-users";
        } catch (IllegalArgumentException e) {
            request.getSession().setAttribute("error", e.getMessage());
            return "errorPage";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/create")
    public String createUser(
            @RequestParam("first_name") String first_name,
            @RequestParam("last_name") String last_name,
            @RequestParam("age") String age,
            Model model,
            HttpServletRequest request
    ) {
        if (first_name == null || first_name.isEmpty() ||
                last_name == null || last_name.isEmpty() ||
                age == null || age.isEmpty()) {
        return "errorPage";
        }
        try {
            int ageUser = Integer.parseInt(age);
            User newUser = new User(first_name, last_name, ageUser);
            userRepository.createUser(newUser);
            return "redirect:/hello/show-users";
        } catch (IllegalArgumentException e) {
            request.getSession().setAttribute("error", e.getMessage());
            return "errorPage";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (userRepository != null) {
                userRepository.close();

            }}
    }


//    @RequestMapping("/page")
//    public String page() {         //можно в скобках указать имя параметра
//
//        return "hello";
//    }

            // первый способ
//    @RequestMapping("/page")
//    public String page(Model model) {
//        model.addAttribute("message", "Hello World");
//        return "hello";
//    }

//    @GetMapping("/page")
//    public String page(@RequestParam(value = "name", required = false) String name,@RequestParam(value = "age",required = false) Integer age) {         //можно в скобках указать имя параметра
//        System.out.println(name);
//        System.out.println(age);
//        return "hello";
//    }
//    @GetMapping("/create")
//    public String create() {
//        return "create";
//    }
//    @PostMapping("/create")
//    public String post(@RequestBody CreateUser user) {
//        System.out.println(user.getName());
//        System.out.println(user.getAge());
//        return "hello";
//    }
//    @GetMapping("/path/{namde}/test")//передача данный через путь /
//    public String path(@PathVariable String name) {
//        System.out.println(name);
//        return "hello";
//    }

//    @RequestMapping("/page")
//    @ResponseBody//вернется все на страницу
//    public String page4(Model model) {
//
//        return "hello";
//    }

            // второй способ передачи
//    @RequestMapping("/page")
//    public String page2(Map<String,Object> map) {
//        map.put("message", "Hello World");
//        return "hello";
//    }

            // третий способ передачи
//    @RequestMapping("/page")
//    public ModelAndView page3() {
//
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("message", "Hello World");
//        mav.setView("hello")
//        return mav;
//    }


//    @RequestMapping(method = RequestMethod.POST)
//    public String page1(){
//        return "hello";
//    }


}
