package io.study.lombok.lombok_howto.lomok_data;

import io.study.lombok.lombok_howto.member.Department;
import io.study.lombok.lombok_howto.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ToStringTest {

    @Test
    public void 양방향_순환_참조_TEST(){
        final Member member = new Member();
        member.setName("abc");
        member.setEmail("abc@gmail.com");

        Department deptTrader = new Department();
        member.setDepartment(deptTrader);

        List<Member> members = new ArrayList<>();
        members.add(member);
        deptTrader.setMembers(members);

        Assertions.assertThatThrownBy(
            () -> System.out.println(member)
        ).isInstanceOf(StackOverflowError.class);
    }
}
