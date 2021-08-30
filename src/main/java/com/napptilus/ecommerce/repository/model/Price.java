package com.napptilus.ecommerce.repository.model;

import javax.persistence.*;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PRICE")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Price {
    @EmbeddedId
    private PriceId priceId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private double price;
    @Enumerated(EnumType.STRING)
    private CurrencyType currency;
    private LocalDateTime LastUpdate;
    private String lastUpdateBy;
}
