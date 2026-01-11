package com.staysphere.platform.entity;


import com.staysphere.platform.entity.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String transactionId;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus payment;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;
}
