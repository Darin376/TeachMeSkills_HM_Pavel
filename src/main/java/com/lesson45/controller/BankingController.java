package com.lesson45.controller;

import com.lesson45.dto.TransferCardToCardDTO;
import com.lesson45.model.Client;
import com.lesson45.service.BankingService;
import com.lesson45.util.AppError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

import static com.lesson45.util.Validation.isValidAmount;
import static com.lesson45.util.Validation.isValidBalance;

@RestController
@RequestMapping("/banking")
public class BankingController {

    @GetMapping("/health")
    public String healthCheck() {
        System.out.println("Health Check");
        return "OK";
    }

    @Autowired
    private BankingService bankingService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getClientById(@PathVariable int id) {
        System.out.println("Health Check");
        Client client = bankingService.getUserById(id);
        if (client != null) {
            return  new ResponseEntity<>(client, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    };

//    @GetMapping("/{id}")
//    public ResponseEntity<?> getClientCardById(@PathVariable int id) {
//
//        return null;
//    }

    @PostMapping(value = "/transfer",consumes = "application/json")
    public ResponseEntity<?> transfer(@RequestBody TransferCardToCardDTO dto){
        System.out.println(dto);

        if(!isValidAmount(dto)) {
            return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(), "Сумма трансфера не может быть отрицательной."), HttpStatus.BAD_REQUEST);
        }
//        if(!isValidBalance(dto)){
//            return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(), "На карте не достаточно средств"), HttpStatus.BAD_REQUEST);
//        }

        try {
            bankingService.transfer(dto);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (SQLException e) {
            return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(),e.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }


}


//CREATE TABLE bankUser (
//        id SERIAL PRIMARY KEY,
//        name VARCHAR(50) UNIQUE NOT NULL
//);
//
//
//CREATE TABLE userCard (
//        id SERIAL PRIMARY KEY,  -- Уникальный ID для каждой машины
//        user_id INT NOT NULL,   -- Ссылка на владельца (без UNIQUE)
//card  VARCHAR(50) NOT NULL,
//FOREIGN KEY (user_id) REFERENCES bankUser(id)
//        );
//
//ALTER TABLE userCard
//ADD COLUMN money DECIMAL(15, 2) NOT NULL DEFAULT 0.00;
//
//INSERT INTO bankUser (name) VALUES
//('ирина Пет'),
//        ('Анна Сидорова')
//
//INSERT INTO userCard (user_id, card, money) VALUES
//(3, '1111  22222 3333 4444', 5000.50),   -- Карта пользователя 1
//        (1, '5536 9132 4567 1234', 5000.00),    -- Вторая карта пользователя 1
//        (2, '5168 7423 9876 5432', 23000.75)   -- Карта пользователя 2
//
//
//SELECT * FROM bankUser;
//SELECT * FROM userCard;
//
//
//SELECT b.id, b.name, u.money
//FROM bankUser b
//JOIN userCard u ON b.id = u.user_id
//WHERE b.id = 1;
//
//
//BEGIN;
//
//-- Блокируем строки для изменения
//SELECT money FROM userCard WHERE id = 1 FOR UPDATE;
//SELECT money FROM userCard WHERE id = 2 FOR UPDATE;
//
//-- Проверка баланса
//DO $$
//DECLARE
//from_balance DECIMAL(15, 2);
//BEGIN
//SELECT money INTO from_balance FROM userCard WHERE id = 1;
//IF from_balance < 1000.00 THEN
//RAISE EXCEPTION 'Недостаточно средств';
//END IF;
//END $$;
//
//-- Перевод
//UPDATE userCard SET money = money - 1000.00 WHERE id = 1;
//UPDATE userCard SET money = money + 1000.00 WHERE id = 2;
//
//COMMIT;
//
//SELECT money FROM userCard WHERE user_id = 2 AND card = '5536 9132 4567 1234';
//UPDATE userCard SET money = 9000 WHERE user_id = 2 AND card = '5536 9132 4567 1234';
//
//UPDATE userCard SET money = money + 500 WHERE card = '5536 9132 4567 1234';
//
//
//SELECT * FROM userCard WHERE card = '4276 3800 1234 2221';
//
//SELECT * FROM userCard
//WHERE card IN ('4276 3800 1234 2221', '5536 9132 4567 1234');
//SELECT * FROM userCard WHERE card = '5536 9132 4567 1234';
//SELECT * FROM bankUser WHERE id = 1;
//SELECT u.id as user_id, u.name, c.card, c.money
//FROM bankUser u
//JOIN userCard c ON u.id = c.user_id;
//
//CREATE INDEX idx_user_card ON userCard(card);
//CREATE INDEX idx_user_id_card ON userCard(user_id, card);
//
//
//
//SELECT money FROM userCard WHERE user_id = 2 AND card = '5536 9132 4567 1234'
//SELECT money FROM userCard WHERE user_id = 1 AND card = '4276 3800 1234 2221'
//SELECT id FROM userCard WHERE card = '5536 9132 4567 1234'
//UPDATE userCard SET money = money - 1000 WHERE user_id = 1 AND card = '4276 3800 1234 2221'
//UPDATE userCard SET money = money + 1000 WHERE card = '5536 9132 4567 1234'
//
//SELECT * FROM userCard;


//
//sql код для таблиц