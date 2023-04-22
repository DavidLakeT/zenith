package me.davidlake.zenith.controller;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import me.davidlake.zenith.dto.response.Response;
import me.davidlake.zenith.model.Product;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    @GetMapping
    public Response getAllProducts() {
        return Response
                .ok()
                .setPayload("Product list.");
    }
    
    @PostMapping
    public Response createProduct(@RequestBody Product product) {
        return Response
                .ok()
                .setPayload("Product created succesfully.");
    }
}
