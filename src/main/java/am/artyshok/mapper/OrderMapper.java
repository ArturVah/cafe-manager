package am.artyshok.mapper;

import am.artyshok.dto.Order;
import am.artyshok.dto.OrderProduct;
import am.artyshok.dto.OrderRequest;
import am.artyshok.entity.OrderEntity;
import am.artyshok.entity.OrderProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,componentModel = "spring")
public interface OrderMapper {

    @Mapping(source = "tableId",target = "table.id")
    @Mapping(source = "waiterId",target = "waiter.id")
    OrderEntity map(Order order);

    @Mapping(source = "table.id",target = "tableId")
    @Mapping(source = "waiter.id",target = "waiterId")
    Order map(OrderEntity orderEntity);


    @Mapping(source = "table.id",target = "tableId")
    @Mapping(source = "waiter.id",target = "waiterId")
    OrderRequest mapEntityToRequestDto(OrderEntity orderEntity);

    @Mapping(source = "tableId",target = "table.id")
    @Mapping(source = "waiterId",target = "waiter.id")
    OrderEntity mapOrderReqToOrderEntity(Order order);

    List<OrderProduct> mapEntityToDto (List<OrderProductEntity> orderProductEntities);

    List<OrderProductEntity> map(List<OrderProduct> orderProducts);

    @Mapping(source = "order.id",target = "orderId")
    @Mapping(source = "product.id",target = "productId")
    OrderProduct map(OrderProductEntity orderProductEntity);

    @Mapping(source = "orderId",target = "order.id")
    @Mapping(source = "productId",target = "product.id")
    OrderProductEntity map(OrderProduct orderProduct);


}
