package am.artyshok.dto;

import am.artyshok.enums.OrderProductStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderProduct {

    private Long orderId;

    private Long productId;

    private Integer quantity;

    private OrderProductStatus orderProductStatus;
}
