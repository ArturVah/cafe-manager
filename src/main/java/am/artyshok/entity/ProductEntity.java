package am.artyshok.entity;

import am.artyshok.entity.base.AbstractEntity;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;


@Getter
@Setter
@Entity
@Table(name = "products")
public class ProductEntity extends AbstractEntity {

    @Column
    private String name;

    @Column
    private BigDecimal price;
}
