package am.artyshok.dto;

import am.artyshok.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private Long tableId;

    private Long waiterId;

    private List<OrderProduct> productsInOrder;

    private OrderStatus orderStatus;
}
