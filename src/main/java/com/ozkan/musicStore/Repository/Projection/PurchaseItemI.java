package com.ozkan.musicStore.Repository.Projection;


import java.time.LocalDateTime;

public interface PurchaseItemI
{
    String getName();
    String getPrice();
    LocalDateTime getPurchaseTime();

}
