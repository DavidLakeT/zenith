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
import org.modelmapper.ModelMapper;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class ProductService {
 
    @Autowired
    private ProductRepository productRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ModelMapper modelMapper;

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
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
                        .map(product -> modelMapper.map(product, ProductDTO.class))
                        .collect(Collectors.toList());
    }
 
    public Optional<ProductDTO> getProductById(Long id) {
        return productRepository.findById(id)
                .map(product -> modelMapper.map(product, ProductDTO.class));
    }
 
    public ProductDTO createProduct(ProductDTO product) {
        Product productModel = modelMapper.map(product, Product.class);
        productRepository.save(productModel);
        return modelMapper.map(productModel, ProductDTO.class);
    }
 
    public Optional<ProductDTO> deleteProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()) {
            productRepository.delete(product.get());
            ProductDTO productDTO = ProductMapper.toProductDTO(product.get());
            return Optional.ofNullable(productDTO);
        }
        return Optional.empty();
    }
    
    public Optional<ProductDTO> updateProduct(Long id, ProductDTO updatedProduct) {
        Optional<Product> product = productRepository.findById(id);
        if(!product.isPresent()) {
            return Optional.empty();
        }
        Product productModel = modelMapper.map(updatedProduct, Product.class);
        productRepository.save(productModel);
        return Optional.ofNullable(modelMapper.map(productModel, ProductDTO.class));
    }
}
