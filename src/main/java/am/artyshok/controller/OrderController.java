package am.artyshok.controller;

import am.artyshok.dto.Order;
import am.artyshok.dto.OrderProduct;
import am.artyshok.dto.OrderRequest;
import am.artyshok.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {


    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    /**
     * @param order to persist in database
     * @return Created order with id
     */
    @PostMapping
    public ResponseEntity<?> registerOrder(@RequestBody Order order) {
        Order createdOrder = orderService.create(order);
        return ResponseEntity.ok(createdOrder);
    }

    /**
     * @param orderId which must be edited
     * @param order new order object to put in database
     * @return updated order object
     */
    @PutMapping("/{orderId}")
    public ResponseEntity<?> editOrder(@PathVariable Long orderId, @RequestBody OrderRequest order) {
        order = orderService.editOrder(orderId, order);
        return ResponseEntity.ok(order);
    }

    /**
     * @param productsInOrderId which must be updated
     * @param productsInOrder   object to put in database
     * @return  updated productsInOrder object
     */
    @PutMapping("/{productsInOrderId}/products")
    public ResponseEntity<?> editProductsInOrder(@PathVariable Long productsInOrderId, @RequestBody OrderProduct productsInOrder) {
        productsInOrder = orderService.editProductsInOrder(productsInOrderId, productsInOrder);
        return ResponseEntity.ok(productsInOrder);
    }

}
