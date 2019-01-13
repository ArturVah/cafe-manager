package am.artyshok.entity;

import am.artyshok.entity.base.AbstractEntity;
import am.artyshok.enums.OrderProductStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "orders_products")
public class OrderProductEntity extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @Column
    private Integer quantity;

    @Enumerated(EnumType.STRING)
    private OrderProductStatus orderProductStatus;
}
