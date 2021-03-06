package ru.geekbrains.spring.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.shop.model.Product;
import ru.geekbrains.spring.shop.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository studentRepository;

    public List<Product> getAll() {
        return studentRepository.findAll();
    }

    public Product getById(Long id) {
        return studentRepository.findById(id).get();
    }

    public Product getByName(String name) {
        return studentRepository.findProductById(name);
    }

    public Product add(Product student) {
        return studentRepository.save(student);
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
