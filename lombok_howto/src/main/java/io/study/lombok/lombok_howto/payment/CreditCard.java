package io.study.lombok.lombok_howto.payment;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Embeddable
public class CreditCard {

    @Column(name = "credit_number", nullable = false)
    private String creditNumber;

    @Column(name = "credit_holder", nullable = false)
    private String creditHolder;

    @Builder(builderMethodName = "defaultBuilder")
    public CreditCard(String creditNumber, String creditHolder) {
        Assert.hasText(creditNumber, "신용카드 번호는 비어있을수 없습니다.");
        Assert.hasText(creditHolder, "신용카드 소유자는 비어있을수 없습니다.");
        this.creditNumber = creditNumber;
        this.creditHolder = creditHolder;
    }
}
