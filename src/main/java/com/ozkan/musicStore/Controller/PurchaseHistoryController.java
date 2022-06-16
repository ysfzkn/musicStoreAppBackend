package com.ozkan.musicStore.Controller;

import com.ozkan.musicStore.Model.PurchaseHistory;
import com.ozkan.musicStore.Security.UserPrincipal;
import com.ozkan.musicStore.Service.PurchaseHistoryServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("purchase-history")
public class PurchaseHistoryController
{
    @Autowired
    private PurchaseHistoryServiceI purchaseHistoryService;

    @PostMapping //purchase-history
    public ResponseEntity<?> savePurchaseHistory(@RequestBody PurchaseHistory purchaseHistory)
    {
        return new ResponseEntity<>(purchaseHistoryService.savePurchaseHistory(purchaseHistory),
                HttpStatus.CREATED);
    }

    @GetMapping //purchase-history
    public ResponseEntity<?> getAllPurchasesOfUser(@AuthenticationPrincipal UserPrincipal userPrincipal)
    {
        return ResponseEntity.ok(purchaseHistoryService.findPurchasedItemsOfUser(userPrincipal.getId()));
    }

}
