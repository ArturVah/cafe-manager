package am.artyshok.service;

import am.artyshok.dto.Order;
import am.artyshok.dto.OrderProduct;
import am.artyshok.dto.OrderRequest;
import am.artyshok.entity.*;
import am.artyshok.mapper.OrderMapper;
import am.artyshok.repository.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final TableRepository tableRepository;
    private final ProductsInOrderRepository productsInOrderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public OrderService(OrderMapper orderMapper, OrderRepository orderRepository, TableRepository tableRepository,
                        ProductsInOrderRepository productsInOrderRepository, ProductRepository productRepository, UserRepository userRepository) {
        this.orderMapper = orderMapper;
        this.orderRepository = orderRepository;
        this.tableRepository = tableRepository;
        this.productsInOrderRepository = productsInOrderRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public Order create(Order order) {
        OrderEntity orderEntity = orderMapper.map(order);
        if (order.getTableId() != null) {
            TableEntity tableEntity = tableRepository.getById(order.getTableId());
            orderEntity.setTable(tableEntity);
        }

        if (order.getWaiterId() != null) {
            UserEntity userEntity = userRepository
                    .findById(order.getWaiterId())
                    .orElseThrow(IllegalArgumentException::new);
            orderEntity.setWaiter(userEntity);
        }

        List<OrderProductEntity> orderProductEntities = orderMapper.map(order.getProductsInOrder());

        OrderEntity createdOrderEntity = orderRepository.save(orderEntity);

        List<OrderProductEntity> productsInOrderEntities = orderProductEntities.stream().peek(e -> e.setOrder(orderEntity)).map(productsInOrderRepository::save).collect(Collectors.toList());

        createdOrderEntity.setProductsInOrder(productsInOrderEntities);
        return orderMapper.map(createdOrderEntity);
    }

    public OrderRequest editOrder(Long orderId, OrderRequest order) {
        OrderEntity orderEntity = orderRepository.getById(orderId);

        if (order.getTableId() != null) {
            TableEntity tableEntity = tableRepository.getById(order.getTableId());
            orderEntity.setTable(tableEntity);
        }

        if (order.getOrderStatus() != null) {
            orderEntity.setOrderStatus(order.getOrderStatus());
        }

        return orderMapper.mapEntityToRequestDto(orderRepository.save(orderEntity));
    }

    public OrderProduct editProductsInOrder(Long productsInOrderId, OrderProduct productsInOrder) {
        OrderProductEntity productsInOrderEntity = productsInOrderRepository.getById(productsInOrderId);
        if (productsInOrder.getProductId() != null) {
            ProductEntity productEntity = productRepository.getById(productsInOrder.getProductId());
            productsInOrderEntity.setProduct(productEntity);
        }

        if (productsInOrder.getQuantity() != null) {
            productsInOrderEntity.setQuantity(productsInOrder.getQuantity());
        }

        if (productsInOrder.getOrderProductStatus() != null) {
            productsInOrderEntity.setOrderProductStatus(productsInOrder.getOrderProductStatus());
        }

        return orderMapper
                .map(productsInOrderRepository.save(productsInOrderEntity));
    }
}
