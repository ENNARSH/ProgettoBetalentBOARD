package com.progetto.betalent.board.repository;

import com.progetto.betalent.board.entities.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto,Long> {


    public Prodotto findProdottoBycodProdotto(String codProdotto);
    public void deleteProdottoBycodProdotto(String codProdotto);

    public Prodotto findProdottoByTipoAndAutoCompatibile(String tipo, String autoCompatibile);

    public Prodotto findProdottoByautoCompatibile(String autoCompatibile);
}
