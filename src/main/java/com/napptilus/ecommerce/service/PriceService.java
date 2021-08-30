package com.napptilus.ecommerce.service;

import com.napptilus.ecommerce.repository.model.Price;
import com.napptilus.ecommerce.service.dto.FindPriceRequest;

public interface PriceService {
    Price findPrice(FindPriceRequest findPriceRequest);
}
