package com.bcopstein.CtrlCorredorV1.controller;

import java.util.List;

import com.bcopstein.CtrlCorredorV1.domain.services.CorredorService;
import com.bcopstein.CtrlCorredorV1.view.models.Corredor;
import com.bcopstein.CtrlCorredorV1.view.repositories.CorredorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("corredor")
public class CorredorController {

    @Autowired
    public CorredorService corredorService;

    @GetMapping
    @CrossOrigin(origins = "*")
    public List<Corredor> consultaCorredor() {
        return corredorService.findAllCorredores();
    }

    @PostMapping
    @CrossOrigin(origins = "*")
    public boolean cadastrarCorredor(@RequestBody final Corredor corredor){
        return corredorService.cadastrarCorredor(corredor);
    } 
}       
