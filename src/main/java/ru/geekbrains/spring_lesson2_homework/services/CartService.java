package ru.geekbrains.spring_lesson2_homework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.spring_lesson2_homework.repositories.Cart;
import ru.geekbrains.spring_lesson2_homework.models.Product;

@Component
public class CartService {
    final private String listFormat = "%-5d %-25s %-5d" + System.lineSeparator();
    final private String headerFormat = "%-5s %-25s %-5s" + System.lineSeparator();
    private Cart cart;
    private CartFactory cartFactory;

    @Autowired
    public CartService(Cart cart, CartFactory cartFactory) {
        this.cart = cart;
        this.cartFactory = cartFactory;
    }

    public void addProductToCartById(Product product) {
        cart.addProductToCartById(product);

    }

    public void removeProductFromCartById(Product product) {
        cart.removeProductFromCartById(product);

    }

    public void getCartList() {
        System.out.println();
        System.out.println("Product list in cart: ");
        if (cart.getCartList() != null && cart.getCartList().size() > 0) {
            System.out.printf(headerFormat, "ID", "Title", "Cost");
            cart.getCartList().stream().forEach(s -> System.out.printf(listFormat, s.getId(), s.getTitle(), s.getCost()));
        } else {
            System.out.println("Cart is empty");
        }
        System.out.println();
    }

    public void setCart() {
        this.cart = cartFactory.getNewCart();
    }

}
