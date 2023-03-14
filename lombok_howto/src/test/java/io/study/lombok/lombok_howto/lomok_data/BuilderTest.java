package io.study.lombok.lombok_howto.lomok_data;

import io.study.lombok.lombok_howto.stock.Stock1;
import io.study.lombok.lombok_howto.stock.Stock2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BuilderTest {

    @Test
    public void TEST_NULL_1(){
        Stock1 amzn = Stock1.defaultBuilder()
                .ticker("AMZN")
                .sector("SALES")
                .companyName("Amazon")
                .companyNameEn("Amazon")
                .countryCode(" ") // 국가 코드가 비어있는 상태로 객체를 생성해보자.
                .build();

        assertThat(amzn.getCountryCode()).isBlank();

        Stock1 meta = Stock1.defaultBuilder()
                .ticker("META")
                .sector("IT SERVICE")
                .companyName("Meta")
                .companyNameEn("Meta")
                .countryCode(null) // 국가 코드를 null 로 대입했다.
                .build();

        assertThat(meta.getCountryCode()).isNull();
    }

    @Test
    public void TEST_NULL_2(){
        Assertions.assertThatThrownBy(()->{
            Stock2 amzn = Stock2.defaultBuilder()
                    .ticker("AMZN")
                    .sector("SALES")
                    .companyName("Amazon")
                    .companyNameEn("Amazon")
                    .countryCode(" ") // 국가 코드가 비어있는 상태로 객체를 생성해보자.
                    .build();
        }).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(()->{
            Stock2 meta = Stock2.defaultBuilder()
                    .ticker("META")
                    .sector("IT SERVICE")
                    .companyName("Meta")
                    .companyNameEn("Meta")
                    .countryCode(null) // 국가 코드를 null 로 대입했다.
                    .build();
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
