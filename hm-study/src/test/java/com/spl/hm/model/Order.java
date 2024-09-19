package com.spl.hm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String orderNo;
    private LocalDate date;
    private String customerName;
    private List<OrderLine> orderLines;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OrderLine {
        private String item;
        private int quantity;
        private BigDecimal unitPrice;
    }
}

