package com.codestates.burgerqueenspring;

import com.codestates.burgerqueenspring.discount.Discount;
import com.codestates.burgerqueenspring.discount.discountCondition.CozDiscountCondition;
import com.codestates.burgerqueenspring.discount.discountCondition.DiscountCondition;
import com.codestates.burgerqueenspring.discount.discountCondition.KidDiscountCondition;
import com.codestates.burgerqueenspring.discount.discountPolicy.FixedAmountDiscountPolicy;
import com.codestates.burgerqueenspring.discount.discountPolicy.FixedRateDiscountPolicy;
import com.codestates.burgerqueenspring.order.Order;
import com.codestates.burgerqueenspring.product.ProductRepository;

public class AppConfigurer {

    private Cart cart = new Cart(productRepository(), menu());

    public Menu menu() {
        return new Menu(productRepository());
    }

    public ProductRepository productRepository() {
        return new ProductRepository();
    }

    public Cart cart() {
        return cart;
    }

    public Order order() {
        return new Order(cart(), discount());
    }

    public Discount discount() {
        return new Discount(new DiscountCondition[] {
                new CozDiscountCondition(new FixedRateDiscountPolicy()),
                new KidDiscountCondition(new FixedAmountDiscountPolicy())
        });
    }
}
