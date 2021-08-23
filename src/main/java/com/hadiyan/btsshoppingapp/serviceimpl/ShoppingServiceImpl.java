package com.hadiyan.btsshoppingapp.serviceimpl;

import com.hadiyan.btsshoppingapp.dto.ShoppingDto;
import com.hadiyan.btsshoppingapp.model.Shopping;
import com.hadiyan.btsshoppingapp.repository.ShoppingRepository;
import com.hadiyan.btsshoppingapp.service.ShoppingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingServiceImpl implements ShoppingService {

    private final ShoppingRepository shoppingRepository;

    public ShoppingServiceImpl(ShoppingRepository shoppingRepository) {
        this.shoppingRepository = shoppingRepository;
    }

    @Override
    public Object save(ShoppingDto dto) {
        Shopping shopping = dto.getShopping();
        shoppingRepository.save(shopping);
        return dto;
    }

    @Override
    public List<Shopping> findAll() {
        return shoppingRepository.findAll();
    }

    @Override
    public Shopping findById(Long id){
        return shoppingRepository.findById(id).get();
    }

    @Override
    public Object update(Long id, ShoppingDto dto) {
        Shopping shopping = shoppingRepository.findById(id).get();
        shopping.setName(dto.getShopping().getName());
        shopping.setCreatedDate(dto.getShopping().getCreatedDate());
        shoppingRepository.save(shopping);
        return dto;
    }

    @Override
    public String delete(Long id) {
        if(!shoppingRepository.findById(id).isPresent()) {
            return ("Data Doesn't Exist");
        } else {
            shoppingRepository.deleteById(id);
            return ("Deleted");
        }
    }
}
