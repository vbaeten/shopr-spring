package com.realdolmen.backend.data;

import com.realdolmen.backend.domain.Rating;
import com.realdolmen.backend.dto.RatingDto;

public class RatingTestDataBuilder {

    public static Rating.Builder buildRating1() {
        return Rating.builder()
                .article(ArticleTestDataBuilder.buildArticleFictionBook().build())
                .id(1L)
                .description("Not very good.")
                .score(4)
                .user(UserTestDataBuilder.buildUserJuttaRoggen().build());
    }

    public static Rating.Builder buildRating2() {
        return Rating.builder()
                .article(ArticleTestDataBuilder.buildArticleFictionBook().build())
                .id(2L)
                .description("Loved it!")
                .score(9)
                .user(UserTestDataBuilder.buildUserBernadetteSanz().build());
    }

    public static RatingDto.Builder buildRatingDto1() {
        return RatingDto.builder()
                .article(ArticleTestDataBuilder.buildArticleFictionBookDto().build())
                .id(1L)
                .description("Not very good.")
                .score(4)
                .user(UserTestDataBuilder.buildUserDtoJuttaRoggen().build());
    }

    public static RatingDto.Builder buildRatingDto2() {
        return RatingDto.builder()
                .article(ArticleTestDataBuilder.buildArticleFictionBookDto().build())
                .id(2L)
                .description("Loved it!")
                .score(9)
                .user(UserTestDataBuilder.buildUserDtoBernadetteSanz().build());
    }
}
