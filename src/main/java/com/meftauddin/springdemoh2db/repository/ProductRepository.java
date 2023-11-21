package com.meftauddin.springdemoh2db.repository;

import com.meftauddin.springdemoh2db.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
