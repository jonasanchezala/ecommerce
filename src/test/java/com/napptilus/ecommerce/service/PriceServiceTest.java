package com.napptilus.ecommerce.service;

import com.napptilus.ecommerce.repository.PriceRepository;
import com.napptilus.ecommerce.repository.model.Brand;
import com.napptilus.ecommerce.repository.model.CurrencyType;
import com.napptilus.ecommerce.repository.model.Price;
import com.napptilus.ecommerce.repository.model.PriceId;
import com.napptilus.ecommerce.service.dto.FindPriceRequest;
import com.napptilus.ecommerce.service.exception.PriceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceServiceTest {

    @Mock
    private PriceRepository priceRepository;
    @InjectMocks
    private PriceServiceImpl priceService;

    @Test
    void whenFindPriceRequestIsValidThenFindPriceShouldReturnPrice() {
        List<Price> prices = new ArrayList<>();
        prices.add(Price
                .builder()
                .priceId(PriceId.builder()
                        .productId(1)
                        .priceList(1)
                        .brand(Brand.builder()
                                .id(1)
                                .name("Zara")
                                .build())
                        .build())
                .currency(CurrencyType.EUR)
                .startDate(LocalDateTime.now())
                .endDate(LocalDateTime.now())
                .price(35.5)
                .build());
        when(priceRepository.findByDateAppliedAndProductAndBrand(any(LocalDateTime.class), anyInt(), anyInt()))
                .thenReturn(prices);
        Price priceResult = priceService.findPrice(FindPriceRequest.builder()
                .brandId(1)
                .productId(1)
                .dateApplied(LocalDateTime.now())
                .build());
        assertNotNull(priceResult);
        assertEquals(priceResult.getPrice(), priceResult.getPrice());
        assertEquals(priceResult.getPriceId().getBrand().getId(), priceResult.getPriceId().getBrand().getId());
    }

    @Test
    void whenThereAreNotResultsThenFindPriceThrowPriceNotFoundException() {
        when(priceRepository.findByDateAppliedAndProductAndBrand(any(LocalDateTime.class), anyInt(), anyInt()))
                .thenReturn(new ArrayList<>());
        PriceNotFoundException priceNotFoundException = assertThrows(PriceNotFoundException.class, () ->
            priceService.findPrice(FindPriceRequest.builder()
                    .brandId(1)
                    .productId(1)
                    .dateApplied(LocalDateTime.now())
                    .build())
        );
        assertEquals("Price not found", priceNotFoundException.getMessage());
    }
}