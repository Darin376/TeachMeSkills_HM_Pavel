package com.exampleTrenningLesson45;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/group")
public class GroupController {


    // Простой эндпоинт для проверки работоспособности
    @GetMapping("/health")
    public String healthCheck() {
        System.out.println("Health Check");
        return "OK";
    }

    @PutMapping("/{id}")
    public ResponseEntity<Group> updateGroup(@PathVariable int id , @RequestBody Group group) {//  если по id
        System.out.println(group);
        return new ResponseEntity<>(group, HttpStatus.CREATED);
    }

    @PostMapping(consumes = "application/json")//  в какои формате должны принять данные
    public ResponseEntity<Group> createGroup(@RequestBody Group group) {//  если принемаем обьект то дожны пометить его RequestBody
        System.out.println(group);
        return new ResponseEntity<>(group, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}",produces = "application/json")// преобразовываем в json  но ResponseEntity ток же преобразовывает
    public ResponseEntity<Group> findGroup(@PathVariable int id) {
        return new ResponseEntity<>(new Group(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Group> deleteGroup(@PathVariable int id) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
