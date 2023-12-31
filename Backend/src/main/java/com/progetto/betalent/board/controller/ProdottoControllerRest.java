package com.progetto.betalent.board.controller;

import com.progetto.betalent.board.entities.Prodotto;
import com.progetto.betalent.board.service.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
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




    @GetMapping("prodotti/{auto}/{budget}")
    public ResponseEntity<List<Prodotto>> logicaSortPreventivoTest(@PathVariable String auto, @PathVariable Double budget) {
        List<Prodotto> prodotti = service.findAllProdottoByautoCompatibile(auto);
        List<Prodotto> result = new ArrayList<>();
        long totalCost = 0;

        prodotti.sort(Comparator.comparingDouble(p -> (double) p.getPrezzo() / p.getPriorita())); // Ordina i prodotti in base al rapporto prezzo/priorità

        for (Prodotto prodotto : prodotti) {
            long currentCost = prodotto.getPrezzo();

            if (totalCost + currentCost <= budget) {
                totalCost += currentCost;
                result.add(prodotto);
            } else {
                prodotto.setDescrizione(prodotto.getDescrizione() + " - Out of Budget");
                result.add(prodotto);
            }
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("prodotti/{tipo}/{auto}/{budget}")
    public ResponseEntity<List<Prodotto>> logicaSortPreventivoFinale(@PathVariable String tipo,@PathVariable String auto, @PathVariable Double budget) {
        List<Prodotto> prodotti = service.findAllProdottoByTipoAndAutoCompatibile(tipo,auto);
        System.out.println(prodotti);
        List<Prodotto> result = new ArrayList<>();
        long totalCost = 0;

        prodotti.sort(Comparator.comparingDouble(p -> (double) p.getPrezzo() / p.getPriorita())); // Ordina i prodotti in base al rapporto prezzo/priorità

        for (Prodotto prodotto : prodotti) {
            long currentCost = prodotto.getPrezzo();

            if (totalCost + currentCost <= budget) {
                totalCost += currentCost;
                result.add(prodotto);
            } else {
                prodotto.setDescrizione(prodotto.getDescrizione() + " - Out of Budget");
                result.add(prodotto);
            }
        }

        return ResponseEntity.ok(result);
    }



}
