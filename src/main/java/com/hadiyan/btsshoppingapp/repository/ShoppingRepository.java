package com.hadiyan.btsshoppingapp.repository;

import com.hadiyan.btsshoppingapp.model.Shopping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingRepository extends JpaRepository<Shopping, Long> {
}
