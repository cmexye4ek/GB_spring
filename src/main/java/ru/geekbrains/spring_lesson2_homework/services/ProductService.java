package ru.geekbrains.spring_lesson2_homework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.spring_lesson2_homework.models.Product;
import ru.geekbrains.spring_lesson2_homework.repositories.ProductRepository;

import java.util.List;

@Component
public class ProductService {
    final private String listFormat = "%-5d %-25s %-5d" + System.lineSeparator();
    final private String headerFormat = "%-5s %-25s %-5s" + System.lineSeparator();
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductById(Long id) {
        return productRepository.getProductById(id);
    }

    public List<Product> getProductList() {
        return productRepository.getProductList();
    }

    public void printProductList() {
        System.out.println("Product list: ");
        System.out.printf(headerFormat, "ID", "Title", "Cost");
        productRepository.getProductList().stream().forEach(s -> System.out.printf(listFormat, s.getId(), s.getTitle(), s.getCost()));
        System.out.println();
    }

}
