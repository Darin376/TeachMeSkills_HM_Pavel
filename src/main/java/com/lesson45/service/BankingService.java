package com.lesson45.service;

import com.lesson45.dto.TransferCardToCardDTO;
import com.lesson45.model.Card;
import com.lesson45.model.Client;
import com.lesson45.postgresDriverManager.PostgresDriverManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class BankingService {
    @Autowired
    private PostgresDriverManager postgresDriverManager;

    public Client getUserById(int id) {

        String sql = "SELECT b.id, b.name, u.card, u.money FROM bankUser b JOIN userCard u ON b.id = u.user_id WHERE b.id = ?;";

        try (Connection connection = postgresDriverManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            Client client = null;
            List<Card> cards = new ArrayList<>();
            while (resultSet.next()) {
                if (client == null) {
                    client = new Client();
                    client.setId(resultSet.getInt("id"));
                    client.setName(resultSet.getString("name"));
                }

                Card card = new Card();
                card.setId(resultSet.getInt("id"));
                card.setCardNumber(resultSet.getString("card"));
                card.setMoney(resultSet.getBigDecimal("money"));
                cards.add(card);
            }
            if (client != null) {
                client.setCards(cards);
                return client;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void transfer(TransferCardToCardDTO dto) throws SQLException {
        Connection connection = null;
        try {
            connection = postgresDriverManager.getConnection();
            connection.setAutoCommit(false);


            // 1. Проверка карты отправителя
            String sqlFrom = "SELECT money FROM userCard WHERE user_id = ? AND card = ?";
            try (PreparedStatement psFrom = connection.prepareStatement(sqlFrom)) {
                psFrom.setInt(1, dto.getClientId());
                psFrom.setString(2, dto.getCardTo());

                ResultSet rsFrom = psFrom.executeQuery();

                System.out.println(rsFrom +"esform");
                if (!rsFrom.next()) {
                    throw new SQLException("Карта отправителя не найдена");
                }

                BigDecimal balanceFrom = rsFrom.getBigDecimal("money");
                if (balanceFrom.compareTo(dto.getAmount()) < 0) {
                    throw new SQLException("Недостаточно средств на карте отправителя");
                }
                System.out.println(balanceFrom +"balanceFrom");
            }

            // 2. Проверка карты получателя
            String sqlTo = "SELECT id FROM userCard WHERE card = ?";
            try (PreparedStatement psTo = connection.prepareStatement(sqlTo)) {
                psTo.setString(1, dto.getCardFrom().getCardNumber());

                ResultSet rsTo = psTo.executeQuery();
                System.out.println(rsTo +"rsTo");
                if (!rsTo.next()) {
                    throw new SQLException("Карта получателя не найдена");
                }
            }

            // 3. Списание средств
            String sqlUpdateFrom = "UPDATE userCard SET money = money - ? WHERE user_id = ? AND card = ?";
            try (PreparedStatement psUpdateFrom = connection.prepareStatement(sqlUpdateFrom)) {
                psUpdateFrom.setBigDecimal(1, dto.getAmount());
                psUpdateFrom.setInt(2, dto.getClientId());
                psUpdateFrom.setString(3, dto.getCardTo());
                psUpdateFrom.executeUpdate();
            }

            // 4. Зачисление средств
            String sqlUpdateTo = "UPDATE userCard SET money = money + ? WHERE card = ?";
            try (PreparedStatement psUpdateTo = connection.prepareStatement(sqlUpdateTo)) {
                psUpdateTo.setBigDecimal(1, dto.getAmount());
                psUpdateTo.setString(2, dto.getCardFrom().getCardNumber());
                psUpdateTo.executeUpdate();
            }

            connection.commit();
        } catch (SQLException e) {
            if (connection != null) {
                connection.rollback();
            }
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
}
