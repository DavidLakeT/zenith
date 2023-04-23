package me.davidlake.zenith.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.EntityNotFoundException;
import me.davidlake.zenith.model.Product;
import me.davidlake.zenith.repository.ProductRepository;
import org.hibernate.Session;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class ProductService {
 
    @Autowired
    private ProductRepository productRepository;

    @PersistenceContext
    private EntityManager entityManager;
 
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getFilteredProducts(double minPrice, double maxPrice, String color) {
        Session session = entityManager.unwrap(Session.class);
        session.enableFilter("priceFilter")
            .setParameter("minPriceParam", minPrice)
            .setParameter("maxPriceParam", maxPrice);
        session.enableFilter("colorFilter").setParameter("colorParam", color);

        return session.createQuery("from Product", Product.class).list();
    }
 
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found"));
    }

    public List<Product> getProductsByBrand(String brand) {
        return productRepository.findByBrand(brand);
    }

    public List<Product> getProductsByPrice(double price) {
        return productRepository.findByPrice(price);
    }

    public List<Product> getProductsByColor(String color) {
        return productRepository.findByColor(color);
    }
 
    public Product createProduct(Product Product) {
        return productRepository.save(Product);
    }
 
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
 
    public Product updateProduct(Long id, Product updatedProduct) {
        Product product = productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found"));
        product.setBrand(updatedProduct.getBrand());
        product.setPrice(updatedProduct.getPrice());
        return productRepository.save(product);
    }
}
