package com.ozkan.musicStore.Model;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table( name = "purchase_history" )
public class PurchaseHistory
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( name = "user_id", nullable = false)
    private Long userId;

    @Column( name = "instrument_id", nullable = false)
    private Long instrumentId;

    @Column( name = "price", nullable = false)
    private Double price;

    @Column( name = "purchase_time", nullable = false)
    private LocalDateTime purchaseTime;

}
