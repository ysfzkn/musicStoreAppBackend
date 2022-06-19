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

    @Column( name = "name", nullable = false, length = 100)
    private String name;

    @Column( name = "model", nullable = false, length = 100)
    private String model;

    // May be adding new type class
    @Column( name = "type", nullable = false, length = 100)
    private String type;

    @Column( name = "price", nullable = false)
    private Double price;

    @Column(name = "picByte", length = 1000)
    private byte[] picByte;

    @Column( name = "create_time", nullable = false)
    private LocalDateTime createTime;
}
