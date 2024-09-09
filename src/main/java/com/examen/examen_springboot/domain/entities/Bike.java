package com.examen.examen_springboot.domain.entities;



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
@Table(name = "bicicletas")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Bike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "DECIMAL(10,2)", nullable = false)
    private Float precio;

    @Column(columnDefinition = "INT", nullable = false)
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "modelo")
    private Model model;

    @ManyToOne
    @JoinColumn(name = "marca")
    private Brand brand;

}
