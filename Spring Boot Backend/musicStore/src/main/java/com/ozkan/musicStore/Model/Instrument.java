package com.ozkan.musicStore.Model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table( name = "intruments" )
public class Instrument
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( name = "model", nullable = false, length = 100)
    private String model;

    @Column( name = "brand", nullable = false, length = 100)
    private String brand;

    // May be adding new type class
    @Column( name = "type", nullable = false, length = 100)
    private String type;

    @Column( name = "price", nullable = false)
    private Double price;

    @Column( name = "create_time", nullable = false)
    private LocalDateTime createTime;
}
