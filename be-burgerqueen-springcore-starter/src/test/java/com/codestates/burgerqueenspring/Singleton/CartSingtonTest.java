package com.codestates.burgerqueenspring.Singleton;

import com.codestates.burgerqueenspring.AppConfigurer;
import com.codestates.burgerqueenspring.Cart;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CartSingtonTest {
    @Test
    void checkCartSingleton() {

        // given - 컨테이너 생성
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfigurer.class);

        // when - 빈 조회
        Cart cart = applicationContext.getBean("cart", Cart.class);
        Cart cart2 = applicationContext.getBean("cart", Cart.class);

        // 출력
        System.out.println("cart = " + cart);
        System.out.println("cart2 = " + cart2);

        // then - 검증
        Assertions.assertThat(cart).isSameAs(cart2);

    }
}
