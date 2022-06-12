package com.ozkan.musicStore.Service;

import com.ozkan.musicStore.Model.PurchaseHistory;
import com.ozkan.musicStore.Repository.Projection.PurchaseItemI;
import com.ozkan.musicStore.Repository.PurchaseHistoryRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PurchaseHistoryService implements PurchaseHistoryServiceI
{
    @Autowired
    private PurchaseHistoryRepositoryI purchaseHistoryRepository;

    @Override
    public PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory)
    {
        purchaseHistory.setPurchaseTime(LocalDateTime.now());
        return purchaseHistoryRepository.save(purchaseHistory);
    }

    @Override
    public List<PurchaseItemI> findPurchasedItemsOfUser(Long userId)
    {
        return purchaseHistoryRepository.findAllPurchasesOfUser(userId);
    }
}
