package com.examen.examen_springboot.domain.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "detalles_ventas")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class SaleDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "INT", nullable = false)
    private Integer cantidad;

    @Column(columnDefinition = "DECIMAL(10,2)", nullable = false)
    private Float precio_unitario;

    @ManyToOne
    @JoinColumn(name = "venta_id")
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "bicicleta_id")
    private Bike bike;
}
