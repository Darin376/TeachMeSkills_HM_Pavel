package com.lesson49.comtroller;

import com.lesson49.dao.UserDAO;
import com.lesson49.entity.Bankuser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class BankuserController {

    @Autowired
    private UserDAO userDAO;

    @GetMapping
    public ResponseEntity<List<Bankuser>> getAllUsersWithCards() {
        List<Bankuser> users = userDAO.getBankUSer();
        return ResponseEntity.ok(users);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Bankuser> getUserWithCards(@PathVariable int id) {
//        return userDAO.findById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
}