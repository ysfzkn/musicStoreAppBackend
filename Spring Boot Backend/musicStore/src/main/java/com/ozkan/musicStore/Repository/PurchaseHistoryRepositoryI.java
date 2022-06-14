package com.ozkan.musicStore.Repository;

import com.ozkan.musicStore.Model.PurchaseHistory;
import com.ozkan.musicStore.Repository.Projection.PurchaseItemI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PurchaseHistoryRepositoryI extends JpaRepository<PurchaseHistory, Long>
{
    @Query("select i.name as name, ph.price as price, ph.purchaseTime as purchaseTime " +
            "from PurchaseHistory ph left join Instrument i on i.id = ph.instrumentId " +
            "where ph.userId = :userId")
    List<PurchaseItemI> findAllPurchasesOfUser(@Param("userId") Long userId);
}
