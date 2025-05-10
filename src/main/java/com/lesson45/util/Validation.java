package com.lesson45.util;

import com.lesson45.dto.TransferCardToCardDTO;

import java.math.BigDecimal;

public class Validation {
    public static boolean isValidBalance(TransferCardToCardDTO dto){


        return dto.getCardFrom().getMoney().compareTo(dto.getAmount()) >= 0;
        // чтобы проверка сработала нужно засетать информацию о наличке на карте в меттоде ransfer
    }

    public static boolean isValidAmount(TransferCardToCardDTO dto) {
        System.out.println(dto.getAmount().compareTo(BigDecimal.ZERO));
        return dto.getAmount().compareTo(BigDecimal.ZERO) > 0;
    }
}