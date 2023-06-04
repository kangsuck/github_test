package com.codestates.burgerqueenspring.discount.discountCondition;

import com.codestates.burgerqueenspring.discount.discountPolicy.DiscountPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class CozDiscountCondition implements DiscountCondition {

    private boolean isSatisfied;
    @Autowired
    private DiscountPolicy fixedRateDiscountPolicy;

    public CozDiscountCondition(@Qualifier("fixedRate") DiscountPolicy discountPolicy) {
        this.fixedRateDiscountPolicy = discountPolicy;
    }

    public boolean isSatisfied() {
        return isSatisfied;
    }

    private void setSatisfied(boolean satisfied) {
        isSatisfied = satisfied;
    }

    public void checkDiscountCondition() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("코드스테이츠 수강생이십니까? (1)_예 (2)_아니오");
        String input = scanner.nextLine();

        if (input.equals("1")) setSatisfied(true);
        else if (input.equals("2")) setSatisfied(false);
    }

    public int applyDiscount(int price) {
        return fixedRateDiscountPolicy.calculateDiscountedPrice(price);
    }
}