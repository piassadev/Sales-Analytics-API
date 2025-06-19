package com.piassa.sales_analytics_api.repository;

import com.piassa.sales_analytics_api.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {

}
