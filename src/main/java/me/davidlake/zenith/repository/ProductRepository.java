package me.davidlake.zenith.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import me.davidlake.zenith.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByBrand(String brand);
    List<Product> findByPrice(Double price);
    List<Product> findByColor(String color);
}
