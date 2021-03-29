package org.springframework.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId")
    Integer userId;

    @NotNull
    @Column(name = "Name")
    String name;

    @NotNull
    @Column(name = "Age")
    Integer age;

    @NotNull
    @Column(name = "Email")
    String email;
}
