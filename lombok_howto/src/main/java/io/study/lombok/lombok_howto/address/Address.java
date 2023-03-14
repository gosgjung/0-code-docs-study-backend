package io.study.lombok.lombok_howto.address;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Embeddable
public class Address {

    private String address1;

    private String address2;

    private String zip;

    @Builder(builderMethodName = "defaultBuilder")
    public Address(String address1, String address2, String zip) {
        Assert.hasText(address1, "시/군/구 건물번호 는 비어있을수 없습니다.");
        Assert.hasText(address2, "상세 주소는 비어있을 수 없습니다.");
        Assert.hasText(zip, "우편번호는 비어있을 수 없습니다.");

        this.address1 = address1;
        this.address2 = address2;
        this.zip = zip;
    }

}
