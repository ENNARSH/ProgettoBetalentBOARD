package com.progetto.betalent.board.controller;

import com.progetto.betalent.board.entities.Prodotto;
import com.progetto.betalent.board.service.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest")
public class ProdottoControllerRest {


    @Autowired
    ProdottoService service;


    @GetMapping("prodotti")
    public ResponseEntity<List<Prodotto>> getAll(){
        return new ResponseEntity<>(service.listAll(), HttpStatus.OK);
    }

    @PostMapping("prodotti")
    public ResponseEntity<String> saveProd(@RequestBody Prodotto prod){
        service.save(prod);
        return ResponseEntity.ok("Prodotto Salvato");
    }




}
