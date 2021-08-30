package com.napptilus.ecommerce.service;

import com.napptilus.ecommerce.repository.PriceRepository;
import com.napptilus.ecommerce.repository.model.Price;
import com.napptilus.ecommerce.service.dto.FindPriceRequest;
import com.napptilus.ecommerce.service.exception.PriceNotFoundException;
import java.util.Comparator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PriceServiceImpl implements PriceService{

    private final PriceRepository priceRepository;

    @Override
    public Price findPrice(FindPriceRequest findPriceRequest) {
        return priceRepository.findByDateAppliedAndProductAndBrand(
                findPriceRequest.getDateApplied(),
                findPriceRequest.getProductId(),
                findPriceRequest.getBrandId()
        ).stream()
                .max(Comparator.comparing(price -> price.getPriceId().getPriority())).
                orElseThrow(() -> new PriceNotFoundException("Price not found"));
    }
}
