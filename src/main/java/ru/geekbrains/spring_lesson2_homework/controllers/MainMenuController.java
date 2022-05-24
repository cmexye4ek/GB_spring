package ru.geekbrains.spring_lesson2_homework.controllers;

import org.springframework.stereotype.Component;
import ru.geekbrains.spring_lesson2_homework.services.CartService;
import ru.geekbrains.spring_lesson2_homework.services.ProductService;

import javax.annotation.PostConstruct;
import java.util.Scanner;

@Component
public class MainMenuController {
    private Scanner scanner = new Scanner(System.in);
    private String command;
    private ProductService productService;
    private CartService cartService;


    public MainMenuController(ProductService productService, CartService cartService) {
        this.productService = productService;
        this.cartService = cartService;
    }

    @PostConstruct
    private void start() {
        while (true) {
            System.out.println("Welcome to cart, please enter command (-addToCart [id] -removeFromCart [id] -listCart -clearCart -listStock -exit)");
            command = scanner.nextLine();
            if (command.startsWith("-")) {
                if (command.startsWith("-addToCart")) {
                    cartService.addProductToCartById(productService.getProductById(Long.parseLong(command.split(" ", 2)[1])));
                    System.out.println("Product added to cart");
                    cartService.getCartList();
                }
                if (command.startsWith("-removeFromCart")) {
                    cartService.removeProductFromCartById(productService.getProductById(Long.parseLong(command.split(" ", 2)[1])));
                    System.out.println("Product removed from cart");
                    cartService.getCartList();

                }
                if (command.equals("-listCart")) {
                    cartService.getCartList();
                }
                if (command.equals("-clearCart")) {
                    cartService.setCart();
                    System.out.println("Cart cleared");
                    cartService.getCartList();
                }
                if (command.equals("-listStock")) {
                    productService.printProductList();
                }
                if (command.equals("-exit")) {
                    System.exit(0);
                }
            } else {
                System.out.println("Wrong command");
            }
        }
    }
}
