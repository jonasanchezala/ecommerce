package com.napptilus.ecommerce.controller;

import com.napptilus.ecommerce.controller.dto.FindPriceResponse;
import com.napptilus.ecommerce.service.PriceService;
import com.napptilus.ecommerce.service.dto.FindPriceRequest;
import com.napptilus.ecommerce.service.exception.PriceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class PriceController {

    private final PriceService priceService;

    @GetMapping("/price")
    public ResponseEntity getPrice(@RequestParam
                                   @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss")
                                    LocalDateTime dateApplied,
                                    @RequestParam int productId,
                                    @RequestParam int brandId) {
        try{
            return ResponseEntity.ok(
                    FindPriceResponse.fromModel(
                    priceService.findPrice(
                            FindPriceRequest.builder()
                                    .dateApplied(dateApplied)
                                    .productId(productId)
                                    .brandId(brandId)
                                    .build())
                    ));
        }
        catch (PriceNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
