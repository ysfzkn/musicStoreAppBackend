package com.ozkan.musicStore.Service;

import com.ozkan.musicStore.Model.PurchaseHistory;
import com.ozkan.musicStore.Repository.Projection.PurchaseItemI;

import java.util.List;

public interface PurchaseHistoryServiceI
{
    PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory);

    List<PurchaseItemI> findPurchasedItemsOfUser(Long userId);
}
