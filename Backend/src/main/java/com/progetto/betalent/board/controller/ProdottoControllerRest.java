package com.progetto.betalent.board.controller;

import com.progetto.betalent.board.entities.Prodotto;
import com.progetto.betalent.board.service.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("rest")
public class ProdottoControllerRest {


    @Autowired
    ProdottoService service;


    @GetMapping("prodotti") // visualizza prodotti
    public ResponseEntity<List<Prodotto>> getAll(){
        return new ResponseEntity<>(service.listAll(), HttpStatus.OK);
    }

    @PostMapping("prodotti") // salva prodotto
    public ResponseEntity<String> saveProd(@RequestBody Prodotto prod){
        service.save(prod);
        return ResponseEntity.ok("Prodotto Salvato");
    }

    @PutMapping("prodotti/{codProdotto}")
    public ResponseEntity<Prodotto> updateProd(@RequestBody Prodotto prod, @PathVariable("codProdotto") String cod){
        Optional<Prodotto> prodOp = Optional.ofNullable(service.findProdottoBycodProdotto(cod));
        if (prodOp.isPresent()) {
            Prodotto p = prodOp.get();
            p.setAutoCompatibile(prod.getAutoCompatibile());
            p.setDescrizione((prod.getDescrizione()));
            p.setPrezzo(prod.getPrezzo());
            p.setTipo(prod.getTipo());
            p.setCodici(prod.getCodici());
            p.setCodProdotto(prod.getCodProdotto());
            service.save(p);
            return new ResponseEntity<>(HttpStatus.OK);

        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("prodotti/{codProdotto}")
    public ResponseEntity<HttpStatus> deleteProd(@PathVariable("codProdotto") String cod) {
        try {
       service.deleteProdottoBycodProdotto(cod);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("prodotti/trovapercod/{codProdotto}")  // ricerca per codProd
    public ResponseEntity<Prodotto> findProdottoBycodProdotto(@PathVariable String codProdotto) {
        Optional<Prodotto> prodOp = Optional.ofNullable(service.findProdottoBycodProdotto(codProdotto));
        if (prodOp.isPresent()) {
            return ResponseEntity.ok(prodOp.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


   @GetMapping("prodotti/trovaperauto/{autoCompatibile}")  // ricerca per autoCompatibile
    public ResponseEntity<Prodotto> findProdottoByautoCompatibile(@PathVariable String autoCompatibile) {
        Optional<Prodotto> prodOp = Optional.ofNullable(service.findProdottoByautoCompatibile(autoCompatibile));
        if (prodOp.isPresent()) {
            return ResponseEntity.ok(prodOp.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("prodotti/trovapertipoeauto/{tipo}/{autoCompatibile}")  // ricerca per codProd
    public ResponseEntity<Prodotto> findProdottoByTipoAndAutoCompatibile(@PathVariable String tipo, @PathVariable String autoCompatibile) {
        Optional<Prodotto> prodOp = Optional.ofNullable(service.findProdottoByTipoAndAutoCompatibile(tipo, autoCompatibile));
        if (prodOp.isPresent()) {
            return ResponseEntity.ok(prodOp.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
