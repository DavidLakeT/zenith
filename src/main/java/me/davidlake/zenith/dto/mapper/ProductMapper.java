package me.davidlake.zenith.dto.mapper;

import me.davidlake.zenith.dto.model.ProductDTO;
import me.davidlake.zenith.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public static ProductDTO toProductDTO(Product product) {
        return new ProductDTO()
                .setId(product.getId())
                .setBrand(product.getBrand())
                .setFreeShipping(product.isFreeShipping())
                .setColor(product.getColor())
                .setPrice(product.getPrice());
    }
}
