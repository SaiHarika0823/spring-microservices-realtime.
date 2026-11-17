package com.application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/promotions")
public class PromotionController {

    private List getDatabaseFreebies() {
        List dbTable = new ArrayList();

        Map promo1 = new HashMap();
        promo1.put("skuCode", "FREE-CASE-01");
        promo1.put("itemName", "Complimentary Silicone Phone Case");
        promo1.put("minimumOrderThreshold", new BigDecimal("500.00"));
        promo1.put("active", true);
        dbTable.add(promo1);

        Map promo2 = new HashMap();
        promo2.put("skuCode", "FREE-EARBUDS-99");
        promo2.put("itemName", "VIP Wireless Earbuds");
        promo2.put("minimumOrderThreshold", new BigDecimal("1000.00"));
        promo2.put("active", true);
        dbTable.add(promo2);

        Map expiredPromo = new HashMap();
        expiredPromo.put("skuCode", "OLD-PROMO-00");
        expiredPromo.put("itemName", "New Year Sticker Pack");
        expiredPromo.put("minimumOrderThreshold", new BigDecimal("100.00"));
        expiredPromo.put("active", false);
        dbTable.add(expiredPromo);

        return dbTable;
    }

    @GetMapping("/freebies")
    public List getEligibleFreebies(@RequestParam("orderTotal") BigDecimal orderTotal) {
        List allPromos = getDatabaseFreebies();

        return (List) allPromos.stream()
                .filter(promoObj -> {
                    Map promo = (Map) promoObj;
                    BigDecimal threshold = (BigDecimal) promo.get("minimumOrderThreshold");
                    Boolean isActive = (Boolean) promo.get("active");
                    return Boolean.TRUE.equals(isActive) && orderTotal.compareTo(threshold) >= 0;
                })
                .collect(Collectors.toList());
    }
}