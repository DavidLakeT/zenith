package me.davidlake.zenith.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import me.davidlake.zenith.model.Product;
import me.davidlake.zenith.service.ProductService;
import me.davidlake.zenith.dto.model.ProductFilterDTO;
import me.davidlake.zenith.dto.response.Response;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public Response<Object> getAllProducts() {
        return Response.ok().setPayload(productService.getAllProducts());
    }

    @GetMapping("/filter")
    public Response<Object> searchProducts(@RequestBody ProductFilterDTO filter) {
        return Response.ok().setPayload(productService.getFilteredProducts(filter));
    }

    @GetMapping("/p/{id}")
    public Response<Object> getProductById(@PathVariable Long id) {
        return Response.ok().setPayload(productService.getProductById(id));
    }

    @PostMapping("/create")
    public Response<Object> createProduct(@RequestBody Product product) {
        return Response.ok().setPayload(productService.createProduct(product));
    }

    @PutMapping("/{id}")
    public Response<Object> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        return Response.ok().setPayload(productService.updateProduct(id, updatedProduct));
    }

    @DeleteMapping("/{id}")
    public Response<Object> deleteProduct(@PathVariable Long id) {
        return Response.ok().setPayload(productService.deleteProduct(id));
    }
}

