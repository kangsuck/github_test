package com.codestates.burgerqueenspring.Singleton;

import com.codestates.burgerqueenspring.product.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SingletonTest {
    // 싱글톤 구현 O
    @Test
    void runWithSingleton() {

        TestConfig2 testConfig2 = new TestConfig2();

        // productRepository 객체 생성
        ProductRepository productRepository = testConfig2.productRepository();
        ProductRepository productRepository2 = testConfig2.productRepository();

        // 생성한 두 개의 객체가 같은 참조값을 가지고 있는지 검증
        Assertions.assertThat(productRepository).isSameAs(productRepository2);
    }

    // 테스트를 위한 TestConfig2 클래스
    static class TestConfig2 {

        private final ProductRepository productRepository = new ProductRepository();

        private TestConfig2(){}

        public ProductRepository productRepository() {
            return productRepository;
        }
    }
}
