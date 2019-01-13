package am.artyshok.entity;

import am.artyshok.entity.base.AbstractEntity;
import am.artyshok.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class OrderEntity extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "table_id")
    private TableEntity table;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "waiterId")
    private UserEntity waiter;

    @OneToMany(mappedBy = "order",fetch = FetchType.LAZY)
    private List<OrderProductEntity> productsInOrder;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}