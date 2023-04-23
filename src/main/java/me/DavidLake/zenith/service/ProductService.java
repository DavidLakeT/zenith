package me.davidlake.zenith.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.EntityNotFoundException;
import me.davidlake.zenith.model.Product;
import me.davidlake.zenith.repository.ProductRepository;

@Service
public class ProductService {
 
    @Autowired
    private ProductRepository productRepository;
 
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> filterProducts(String brand, Double price, String color) {
        Specification<Product> spec = Specification.where(null);
        if (brand != null) {
            spec = spec.and((root, query, builder) -> builder.equal(root.get("brand"), brand));
        }
        if (price != null) {
            spec = spec.and((root, query, builder) -> builder.equal(root.get("price"), price));
        }
        if (color != null) {
            spec = spec.and((root, query, builder) -> builder.equal(root.get("color"), color));
        }
        return productRepository.findAll(spec);
    }
 
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found"));
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
