package io.study.lombok.lombok_howto.refund;

import io.study.lombok.lombok_howto.order.Order;
import io.study.lombok.lombok_howto.payment.Account;
import io.study.lombok.lombok_howto.payment.CreditCard;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "refund")
public class Refund {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Account account;

    @Embedded
    private CreditCard creditCard;

    @OneToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    // 무통장입금으로 환불
    @Builder(builderClassName = "ByAccountBuilder", builderMethodName = "byAccountBuilder")
    public Refund(Account account, Order order) {
        Assert.notNull(account, "계좌번호는 비어있을 수 없습니다.");
        Assert.notNull(order, "주문은 비어있을 수 없습니다.");
        this.account = account;
        this.order = order;
    }

    // 신용카드로 환불
    @Builder(builderClassName = "ByCreditCardBuilder", builderMethodName = "byCreditCardBuilder")
    public Refund(CreditCard creditCard, Order order) {
        Assert.notNull(creditCard, "신용카드는 비어있을 수 없습니다.");
        Assert.notNull(order, "주문은 비어있을 수 없습니다.");
        this.creditCard = creditCard;
        this.order = order;
    }
}
