package com.codestates.burgerqueenspring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class MainTest {

    // 스프링 컨테이너 생성
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfigurer.class);

    // 빈 조회 테스트케이스
    @Test
    void findBean() {

        // (1) given => 초기화 또는 테스트에 필요한 입력 데이터
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfigurer.class);

        // (2) when => 테스트 할 동작
        Cart cart = applicationContext.getBean("cart", Cart.class);

        // (3) then => 검증
        Assertions.assertThat(cart).isInstanceOf(Cart.class);
    }
}
