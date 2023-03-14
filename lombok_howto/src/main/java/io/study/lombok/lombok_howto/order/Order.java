package io.study.lombok.lombok_howto.order;

import io.study.lombok.lombok_howto.address.Address;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "orders")
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Address address;

    @Builder(builderMethodName = "defaultBuilder")
    public Order(Address address) {
        Assert.notNull(address, "주소는 비어있을 수 없습니다.");
        this.address = address;
    }
}
