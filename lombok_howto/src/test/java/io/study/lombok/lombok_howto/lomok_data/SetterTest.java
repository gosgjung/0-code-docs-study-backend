package io.study.lombok.lombok_howto.lomok_data;

import io.study.lombok.lombok_howto.member.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Base64;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SetterTest {

    private final ExecutorService executorService = Executors.newFixedThreadPool(2);

    public void encodeEmail(Member member){
        member.setEmail(Base64.getEncoder().encodeToString(member.getEmail().getBytes()));
    }

    public void addOAuth2PrefixVendor(Member member, String vendor){
        final String email = new StringBuilder("###OAuth2###").append(vendor)
                .append("###").append(member.getEmail())
                .toString();

        member.setEmail(email);
    }

    @Test
    public void SETTER_TEST(){
        final Member member = new Member();
        member.setEmail("johndoe@gmail.com");

        encodeEmail(member); // 1)

        // 메서드 내부에서 EMAIL 을 수정하는지 알 수 없다.
        addOAuth2PrefixVendor(member, "GOOGLE"); // 2)

        member.setEmail("안녕하세요"); // 3)
    }

    public void asyncEncodeEmail(Member member){
        executorService.submit(() -> {
            member.setEmail(Base64.getEncoder().encodeToString(member.getEmail().getBytes()));
        });
    }

    @Test
    public void ASYNC_ENCODE_EMAIL_TEST(){
        Member member = new Member();
        member.setEmail("abc@gmail.com");

        for(int i=0; i<100; i++){
            member.setEmail("111@GMAIL.COM");
            asyncEncodeEmail(member);
            System.out.println(">>> (1) " + member.getEmail());

            member.setEmail("abc@gmail.com");
            asyncEncodeEmail(member);
            System.out.println(">>> (2) " + member.getEmail());
        }
    }

    @AfterEach
    public void destroy(){
        executorService.shutdownNow();
    }

}
