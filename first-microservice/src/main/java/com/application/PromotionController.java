package com.application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/promotions")
public class PromotionController {

    // Clean Java record representing a row from the promotional_freebies table
    public record PromoItem(String skuCode, String itemName, BigDecimal minimumOrderThreshold, boolean active) {}

    private List<PromoItem> getDatabaseFreebies() {
        List<PromoItem> dbTable = new ArrayList<>();
        dbTable.add(new PromoItem("FREE-CASE-01", "Complimentary Silicone Phone Case", new BigDecimal("500.00"), true));
        dbTable.add(new PromoItem("FREE-EARBUDS-99", "VIP Wireless Earbuds", new BigDecimal("1000.00"), true));
        dbTable.add(new PromoItem("OLD-PROMO-00", "New Year Sticker Pack", new BigDecimal("100.00"), false));
        return dbTable;
    }

    @GetMapping("/freebies")
    public List<PromoItem> getEligibleFreebies(@RequestParam("orderTotal") BigDecimal orderTotal) {
        List<PromoItem> allPromos = getDatabaseFreebies();

        // EXISTING PRODUCTION BUG: uses > 0 instead of >= 0 and forgets to check promo.active()
        return allPromos.stream()
                .filter(promo -> orderTotal.compareTo(promo.minimumOrderThreshold()) >= 0)
                .collect(Collectors.toList());
    }
}