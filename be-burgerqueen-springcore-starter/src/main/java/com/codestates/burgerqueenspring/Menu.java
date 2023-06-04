package com.codestates.burgerqueenspring;

import com.codestates.burgerqueenspring.product.Product;
import com.codestates.burgerqueenspring.product.ProductRepository;
import com.codestates.burgerqueenspring.product.subproduct.Drink;
import com.codestates.burgerqueenspring.product.subproduct.Hamburger;
import com.codestates.burgerqueenspring.product.subproduct.Side;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Menu {
    private Product[] products;
    @Autowired
    public Menu(ProductRepository products) {
        this.products = products.getAllProducts();
    }

    public void printMenu() {
        System.out.println("[🔻] 메뉴");
        System.out.println("-".repeat(60));

        printHamburgers(true);
        printSides(true);
        printDrinks(true);

        System.out.println();
        System.out.println("🧺 (0) 장바구니");
        System.out.println("📦 (+) 주문하기");
        System.out.println("-".repeat(60));
        System.out.print("[📣] 메뉴를 선택해주세요 : ");
    }

    protected void printDrinks(boolean printPrice) {
        System.out.println("🥤 음료");
        for (Product product : products) {
            if (product instanceof Drink) {
                printEachMenu(product, printPrice);
            }
        }
        System.out.println();
    }

    protected void printSides(boolean printPrice) {
        System.out.println("🍟 사이드");
        for (Product product : products) {
            if (product instanceof Side) {
                printEachMenu(product, printPrice);
            }
        }
        System.out.println();
    }

    private void printHamburgers(boolean printPrice) {
        System.out.println("🍔 햄버거");
        for (Product product : products) {
            if (product instanceof Hamburger) {
                printEachMenu(product, printPrice);
            }
        }
        System.out.println();
    }

    private static void printEachMenu(Product product, boolean printPrice) {
        if (printPrice) System.out.printf("   (%d) %s %5dKcal %5d원\n", product.getId(), product.getName(), product.getKcal(), product.getPrice());
        else System.out.printf("   (%d) %s %5dKcal\n", product.getId(), product.getName(), product.getKcal());
    }
}
