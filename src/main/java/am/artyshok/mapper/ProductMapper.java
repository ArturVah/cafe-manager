package am.artyshok.mapper;

import am.artyshok.dto.Product;
import am.artyshok.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,componentModel = "spring")
public interface ProductMapper {
    ProductEntity map(Product product);

    Product map(ProductEntity productEntity);
}
