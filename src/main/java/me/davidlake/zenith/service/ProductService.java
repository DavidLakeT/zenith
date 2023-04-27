package me.davidlake.zenith.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import me.davidlake.zenith.dto.model.ProductFilterDTO;
import me.davidlake.zenith.model.Product;
import me.davidlake.zenith.dto.mapper.ProductMapper;
import me.davidlake.zenith.dto.model.ProductDTO;
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

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(product -> {
                    ProductDTO productDto = new ProductDTO();
                    return productDto
                            .setId(product.getId())
                            .setBrand(product.getBrand())
                            .setFreeShipping(product.isFreeShipping())
                            .setColor(product.getColor())
                            .setPrice(product.getPrice());
                })
                .collect(Collectors.toList());
    }

    public List<ProductDTO> getFilteredProducts(ProductFilterDTO filter) {
        Session session = entityManager.unwrap(Session.class);

        if(filter.getMinPrice() != null) { 
            session.enableFilter("minPriceFilter")
                .setParameter("minPriceParam", filter.getMinPrice());
        }

        if(filter.getMaxPrice() != null) { 
            session.enableFilter("maxPriceFilter")
                .setParameter("maxPriceParam", filter.getMaxPrice());
        }

        if(filter.getColor() != null) {
            session.enableFilter("colorFilter")
                .setParameter("colorParam", filter.getColor());
        }

        if(filter.getBrand() != null) {
            session.enableFilter("brandFilter")
                .setParameter("brandParam", filter.getBrand());
        }

        if(filter.getFreeShipping() != null) {
            session.enableFilter("freeShippingFilter")
                .setParameter("freeShippingParam", filter.getFreeShipping());
        }

        return session.createQuery("from Product", Product.class)
                        .list()
                        .stream()
                        .map(product -> {
                            ProductDTO productDto = new ProductDTO();
                            return productDto
                                    .setId(product.getId())
                                    .setBrand(product.getBrand())
                                    .setFreeShipping(product.isFreeShipping())
                                    .setColor(product.getColor())
                                    .setPrice(product.getPrice());
                        })
                        .collect(Collectors.toList());
    }
 
    public Optional<ProductDTO> getProductById(Long id) {
        return productRepository.findById(id)
                .map(product -> {
                    ProductDTO productDto = new ProductDTO();
                    return productDto
                            .setId(product.getId())
                            .setBrand(product.getBrand())
                            .setFreeShipping(product.isFreeShipping())
                            .setColor(product.getColor())
                            .setPrice(product.getPrice());
                });
    }
 
    public ProductDTO createProduct(Product product) {
        return ProductMapper.toProductDTO(productRepository.save(product));
    }
 
    public Optional<Product> deleteProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()) {
            productRepository.delete(product.get());
        }

        return product;
    }
 
    public Optional<Product> updateProduct(Long id, Product updatedProduct) {
        Optional<Product> product = productRepository.findById(id);
        if(!product.isPresent()) {
            return product;
        }
        Product productSome = product.get();
        productSome.setBrand(updatedProduct.getBrand());
        productSome.setPrice(updatedProduct.getPrice());
        productSome.setColor(updatedProduct.getColor());
        productSome.setFreeShipping(updatedProduct.isFreeShipping());
        return Optional.ofNullable(productRepository.save(productSome));
    }
}
