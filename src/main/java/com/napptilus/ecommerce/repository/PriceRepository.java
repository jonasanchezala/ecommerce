package com.napptilus.ecommerce.repository;

import com.napptilus.ecommerce.repository.model.Price;
import com.napptilus.ecommerce.repository.model.PriceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, PriceId> {
    @Query("select p from Price p where p.priceId.productId = :productId " +
            "and p.priceId.brand.id = :brandId " +
            "and p.startDate <= :dateApplied and p.endDate >= :dateApplied")
    List<Price> findByDateAppliedAndProductAndBrand(LocalDateTime dateApplied, int productId, int brandId);
}
