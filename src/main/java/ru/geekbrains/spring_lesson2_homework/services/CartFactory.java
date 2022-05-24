package ru.geekbrains.spring_lesson2_homework.services;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;
import ru.geekbrains.spring_lesson2_homework.repositories.Cart;

@Component
public class CartFactory {

    @Lookup
    public Cart getNewCart() {
        return null;
    }
}
