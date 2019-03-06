package com.realdolmen.backend.data;

import com.realdolmen.backend.domain.OrderLine;
import com.realdolmen.backend.dto.OrderLineDto;

public class OrderLineTestDataBuilder {

    public static OrderLine.Builder buildOrderLine1() {
        return OrderLine.builder()
                .id(1L)
                .article(ArticleTestDataBuilder.buildArticleFictionBook().build())
                .quantity(2)
                .user(UserTestDataBuilder.buildUserBernadetteSanz().build())
                .subTotal(49);
    }

    public static OrderLine.Builder buildOrderLine2() {
        return OrderLine.builder()
                .id(1L)
                .article(ArticleTestDataBuilder.buildArticleFictionBook().build())
                .quantity(1)
                .user(UserTestDataBuilder.buildUserBernadetteSanz().build())
                .subTotal(79);
    }

    public static OrderLineDto.Builder buildOrderLine1Dto() {
        return OrderLineDto.builder()
                .id(1L)
                .article(ArticleTestDataBuilder.buildArticleFictionBookDto().build())
                .quantity(2)
                .user(UserTestDataBuilder.buildUserDtoBernadetteSanz().build())
                .subTotal(49);
    }

    public static OrderLineDto.Builder buildOrderLine2Dto() {
        return OrderLineDto.builder()
                .id(1L)
                .article(ArticleTestDataBuilder.buildArticleFictionBookDto().build())
                .quantity(1)
                .user(UserTestDataBuilder.buildUserDtoBernadetteSanz().build())
                .subTotal(79);
    }
}
