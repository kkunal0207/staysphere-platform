package com.staysphere.platform.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "accommodation_inventory",
        uniqueConstraints = @UniqueConstraint
                (
                        name = "unique_accommodation_room_date",
                        columnNames = {"room_id", "accommodation_id", "date"}
                ))
public class AccommodationInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accommodation_id", nullable = false)
    private Accommodation accommodation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    private Integer bookedCount;

    @Column(nullable = false)
    private Integer totalCount;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal surgeFactor;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price; // price = basePrice * surgeFactor

    @Column(nullable = false)
    private String city;

    @Column(nullable=false)
    private Boolean closed;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;


}
