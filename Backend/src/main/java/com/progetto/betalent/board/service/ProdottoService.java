package com.progetto.betalent.board.service;

import com.progetto.betalent.board.entities.Prodotto;
import com.progetto.betalent.board.repository.ProdottoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//utilizzo transaction per utilizzare il query method in repo deleteProdottoBycodProdotto
@Transactional
public class ProdottoService {



    @Autowired
    ProdottoRepository repo;

    //metodo per ottenere la lista dei prodotti
    public List<Prodotto> listAll(){

        List<Prodotto> prod = repo.findAll();
        return prod;
    }

    public Prodotto findProdbyId(Long id){
       return repo.findById(id).get();
    }

   public void save(Prodotto p){
        repo.save(p);
   }

   public void delete(Long id){
        repo.deleteById(id);
   }

   public Prodotto findProdottoBycodProdotto(String codProdotto){
        return repo.findProdottoBycodProdotto(codProdotto);
   }

 public void deleteProdottoBycodProdotto(String codProdotto){
    repo.deleteProdottoBycodProdotto(codProdotto);
 }

    public Prodotto findProdottoByTipoAndAutoCompatibile(String tipo, String autoCompatibile){
        return repo.findProdottoByTipoAndAutoCompatibile(tipo, autoCompatibile);
    }


    public Prodotto findProdottoByautoCompatibile(String autoCompatibile) {
        return repo.findProdottoByautoCompatibile(autoCompatibile);
    }
}
