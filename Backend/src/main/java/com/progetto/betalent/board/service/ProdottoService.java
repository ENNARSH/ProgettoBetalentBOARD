package com.progetto.betalent.board.service;

import com.progetto.betalent.board.entities.Prodotto;
import com.progetto.betalent.board.repository.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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








}
