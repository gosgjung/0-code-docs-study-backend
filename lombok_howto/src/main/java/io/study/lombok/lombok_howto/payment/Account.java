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
public class Account {

    @Column(name = "bank_name", nullable = false)
    private String bankName;

    @Column(name = "account_number", nullable = false)
    private String accountNumber;

    @Column(name = "account_holder", nullable = false)
    private String accountHolder;

    @Builder(builderMethodName = "defaultBuilder")
    public Account(String bankName, String accountNumber, String accountHolder) {
        Assert.hasText(bankName, "계좌명은 비어있으면 안됩니다.");
        Assert.hasText(accountNumber, "계좌번호는 비어있으면 안됩니다.");
        Assert.hasText(accountHolder, "예금주는 비어있으면 안됩니다.");
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
    }
}
