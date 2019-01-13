package am.artyshok.controller;

import am.artyshok.dto.Product;
import am.artyshok.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductsController {
    private final ProductService productService;


    public ProductsController(ProductService productService) {
        this.productService = productService;
    }


    /**
     * @param product to persist in database
     * @return Created product
     */
    @PostMapping
    public ResponseEntity<?> registerProduct(@RequestBody Product product) {
        Product createdProduct = productService.create(product);
        return ResponseEntity.ok(createdProduct);
    }
}
