package com.ibrahim.store.repositories;

import com.ibrahim.store.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    // String
    List<Product> findByName(String name);
    List<Product> findByNameLike(String name);
    List<Product> findByNameNotLike(String name);
    List<Product> findByNameContaining(String name);
    List<Product> findByNameStartingWith(String name);
    List<Product> findByNameContainingIgnoreCase(String name);

    // Numbers
    List<Product> findByPrice(BigDecimal price);
    List<Product> findByPriceGreaterThan(BigDecimal priceIsGreaterThan);
    List<Product> findByPriceGreaterThanEqual(BigDecimal priceIsGreaterThan);
    List<Product> findByPriceLessThanEqual(BigDecimal priceIsLessThan);
    List<Product> findByPriceBetween(BigDecimal priceAfter, BigDecimal priceBefore);

    // Null
    List<Product> findByDescriptionNull();
    List<Product> findByDescriptionNullAndNameNull();

    // sort (OrderBy)
    List<Product> findByNameOrderByPriceAsc(String name);
    List<Product> findByNameOrderByPriceDesc(String name);

    // limit (Top/First)
    List<Product> findTop5ByNameOrderByPrice(String name);
    List<Product> findFirst5ByNameLikeOrderByPrice(String name);

    @Query(value = "select * from products p where p.price between :min and :max order by p.name", nativeQuery = true)
    List<Product> findByProducts(@Param("min") BigDecimal min, @Param("max") BigDecimal max);
}
