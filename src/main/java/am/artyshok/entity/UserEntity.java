package am.artyshok.entity;

import am.artyshok.entity.base.AbstractEntity;
import am.artyshok.enums.UserRole;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity extends AbstractEntity {

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String surname;

    @Enumerated(EnumType.STRING)
    private UserRole role;

}