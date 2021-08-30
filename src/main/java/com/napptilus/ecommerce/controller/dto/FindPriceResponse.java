package com.napptilus.ecommerce.controller.dto;

import com.napptilus.ecommerce.repository.model.Price;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class FindPriceResponse {
    private int productId;
    private int brandId;
    private int priceList;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private double price;

    public static FindPriceResponse fromModel(final Price price){
        return FindPriceResponse
                .builder()
                .productId(price.getPriceId().getProductId())
                .brandId(price.getPriceId().getBrand().getId())
                .priceList(price.getPriceId().getPriceList())
                .startDate(price.getStartDate())
                .endDate(price.getEndDate())
                .price(price.getPrice())
                .build();
    }
}
