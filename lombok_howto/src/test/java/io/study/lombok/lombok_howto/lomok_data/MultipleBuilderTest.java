package io.study.lombok.lombok_howto.lomok_data;

import io.study.lombok.lombok_howto.address.Address;
import io.study.lombok.lombok_howto.order.Order;
import io.study.lombok.lombok_howto.payment.Account;
import io.study.lombok.lombok_howto.payment.CreditCard;
import io.study.lombok.lombok_howto.refund.Refund;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MultipleBuilderTest {

    private Account account;
    private CreditCard creditCard;
    private Address address;

    private Order order;

    @BeforeEach
    public void init(){
        account = Account.defaultBuilder()
                .accountNumber("111111")
                .accountHolder("Warren Buffet")
                .bankName("신한은행")
                .build();

        creditCard = CreditCard.defaultBuilder()
                .creditHolder("Warren Buffet")
                .creditNumber("99999999")
                .build();

        address = Address.defaultBuilder()
                .address1("경기도 성남시 분당구 판교로 777777")
                .address2("신한은행빌딩")
                .zip("1111111")
                .build();

        order = Order.defaultBuilder()
                .address(address)
                .build();
    }

    @Test
    public void 환불테스트__무통장입금(){
        Refund refund = Refund.byAccountBuilder()
                .account(account)
                .order(order)
                .build();

        assertThat(refund.getAccount()).isEqualTo(account);
        assertThat(refund.getOrder()).isEqualTo(order);
    }

    @Test
    public void 환불테스트__환불계좌가_null_일경우_IllegalArgumentException이_발생해야_한다(){
        Assertions.assertThatThrownBy(()->{
            Refund.byAccountBuilder()
                    .account(null)
                    .order(order)
                    .build();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 환불테스트__신용카드(){
        Refund refund = Refund.byCreditCardBuilder()
                .creditCard(creditCard)
                .order(order)
                .build();

        assertThat(refund.getCreditCard()).isEqualTo(creditCard);
        assertThat(refund.getOrder()).isEqualTo(order);
    }

    @Test
    public void 환불테스트__환불하려는_신용카드가_null_인경우_IllegalArgumentException이_발생해야_한다(){
        Assertions.assertThatThrownBy(()->{
            Refund.byCreditCardBuilder()
                    .creditCard(null)
                    .order(order)
                    .build();
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
