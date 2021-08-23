package com.hadiyan.btsshoppingapp.service;

import com.hadiyan.btsshoppingapp.dto.ShoppingDto;
import com.hadiyan.btsshoppingapp.model.Shopping;

import java.util.List;

public interface ShoppingService {
    Object save (ShoppingDto shopping);
    List<Shopping> findAll();
    Shopping findById(Long id);
    Object update(Long id, ShoppingDto dto);
    String delete(Long id);
}
