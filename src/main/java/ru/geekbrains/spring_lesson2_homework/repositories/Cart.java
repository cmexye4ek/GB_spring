package ru.geekbrains.spring_lesson2_homework.repositories;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.geekbrains.spring_lesson2_homework.models.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class Cart {
    private List<Product> cart;

    @PostConstruct
    public void init() {
        this.cart = new ArrayList<>();
    }

    public void addProductToCartById(Product product) {
        cart.add(product);

    }

    public void removeProductFromCartById(Product product) {
        cart.remove(product);

    }

    public List<Product> getCartList() {
        return cart;
    }
}
