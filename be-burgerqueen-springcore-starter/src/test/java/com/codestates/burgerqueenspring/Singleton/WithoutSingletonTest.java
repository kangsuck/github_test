package com.codestates.burgerqueenspring.Singleton;

import com.codestates.burgerqueenspring.product.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class WithoutSingletonTest {
    // 싱글톤 구현 X
    @Test
    void runWithoutSingleton() {

        TestConfig testConfig = new TestConfig();

        // productRepository 객체 생성
        ProductRepository productRepository = testConfig.productRepository();
        ProductRepository productRepository2 = testConfig.productRepository();

        // 출력
        System.out.println("productRepository = " + productRepository);
        System.out.println("productRepository2 = " + productRepository2);

        // 생성한 두 개의 객체가 다른 참조값을 가지고 있는지 검증
        Assertions.assertThat(productRepository).isNotSameAs(productRepository2);
    }

    // 테스트를 위한 TestConfig 클래스
    static class TestConfig {

        public ProductRepository productRepository() {
            return new ProductRepository();
        }
    }

}
