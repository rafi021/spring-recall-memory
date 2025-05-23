package com.ibrahim.store.repositories;

import com.ibrahim.store.dtos.ProductSummary;
import com.ibrahim.store.dtos.ProductSummaryDTO;
import com.ibrahim.store.entities.Category;
import com.ibrahim.store.entities.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
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

    //SQL
    @Query(value = "select * from products p where p.price between :min and :max order by p.name", nativeQuery = true)
    List<Product> findByProducts(@Param("min") BigDecimal min, @Param("max") BigDecimal max);


    //Procedure
    @Procedure("findProductsByPrice")
    List<Product> findByProductsByProcedure(BigDecimal min,BigDecimal max);

    //JPQL
    @Query("select p from Product p where p.price between :min and :max order by p.name")
    List<Product> findByPriceBetweenAndOrderByName(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

    @Query("select count(*) from Product p where p.price between :min and :max")
    long countProducts(@Param("min") BigDecimal min, @Param("max") BigDecimal max);


    @Modifying
    @Query("update Product p set p.price = :newPrice where p.category.id = :categoryId")
    void updatePriceByCategory(BigDecimal newPrice, Byte categoryId);

    //Interface based projection
    @Query("select p.id, p.name from Product p where p.category = :category")
    List<ProductSummary> findByCategory(@Param("category") Category category);

    // Class based projection
//    @Query("select new com.ibrahim.store.dtos.ProductSummaryDTO(p.id, p.name) from Product p where p.category = :category")
//    List<ProductSummaryDTO> findByCategory(@Param("category") Category category);
}
