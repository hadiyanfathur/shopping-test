package com.hadiyan.btsshoppingapp.controller;

import com.hadiyan.btsshoppingapp.dto.ShoppingDto;
import com.hadiyan.btsshoppingapp.model.Shopping;
import com.hadiyan.btsshoppingapp.service.ShoppingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ShoppingController {

    private final ShoppingService service;

    public ShoppingController(ShoppingService service) {
        this.service = service;
    }

    @PostMapping("/shopping")
    public Object save(@RequestBody ShoppingDto dto) {
        return service.save(dto);
    }

    @GetMapping("/shopping")
    public List<Shopping> findAll(){
        return service.findAll();
    }

    @GetMapping("/shopping/{id}")
    public Shopping findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PutMapping("/shopping/{id}")
    public Object update(@PathVariable Long id, @RequestBody ShoppingDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/shopping/{id}")
    public String update(@PathVariable Long id) {
        return service.delete(id);
    }
}
