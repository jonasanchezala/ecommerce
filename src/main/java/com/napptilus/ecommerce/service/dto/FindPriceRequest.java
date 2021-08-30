package com.napptilus.ecommerce.service.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class FindPriceRequest {
    private LocalDateTime dateApplied;
    private int productId;
    private int brandId;
}
