package com.lesson49.comtroller;

import com.lesson49.dao.UserDAO;
import com.lesson49.entity.Bankuser;
import com.lesson49.entity.User;
import com.lesson49.entity.Usercard;
import com.lesson49.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/banking")
public class BankingController {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserService userService;


    @GetMapping("/health")
    public String healthCheck() {
        System.out.println("Health Check");
        return "OK";
    }

    @GetMapping("/1")
    public ResponseEntity<?> getAllUsers() {
        List<User> listUser = userDAO.getAllUser();
        List<Bankuser> listUser2 = userDAO.getBankUSer();

        // Уберите вывод в лог объектов с циклическими ссылками
        System.out.println("Bankusers count: " + listUser2.size());

        if (listUser == null || listUser.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(listUser);
        }
    }
//    @GetMapping("/2")
//    public ResponseEntity<?> getAllUsersBank() {
//        List<Bankuser> listUser = userDAO.getBankUSer();
//
//        if (listUser == null || listUser.isEmpty()) {
//            return new ResponseEntity<>(listUser,HttpStatus.NOT_FOUND);
//        } else {
//            return ResponseEntity.ok(listUser);
//        }
//
//    }

//    @GetMapping
//    public ResponseEntity<?> getAllUsers() {
//        List<Bankuser> listUser = userDAO.getBankUSer();
//        System.out.println(listUser);
//        return new ResponseEntity<>(listUser,HttpStatus.NOT_FOUND);
//    }

}