package am.artyshok.service;

import am.artyshok.dto.Product;
import am.artyshok.entity.ProductEntity;
import am.artyshok.mapper.ProductMapper;
import am.artyshok.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductMapper productMappper;
    private final ProductRepository productRepository;

    public ProductService(ProductMapper productMappper, ProductRepository productRepository) {
        this.productMappper = productMappper;
        this.productRepository = productRepository;
    }


    public Product create(Product product) {
        ProductEntity createdProduct = productRepository.save(productMappper.map(product));
        return productMappper.map(createdProduct);
    }
}
