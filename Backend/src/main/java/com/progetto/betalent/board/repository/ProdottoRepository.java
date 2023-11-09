package com.progetto.betalent.board.repository;

import com.progetto.betalent.board.entities.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto,Long> {
    public Prodotto findProdottoBycodProdotto(String codProdotto);
    public void deleteProdottoBycodProdotto(String codProdotto);

    public List<Prodotto> findAllProdottoByTipoAndAutoCompatibile(String tipo, String autoCompatibile);

    public List<Prodotto> findProdottiByautoCompatibile(String autoCompatibile);

    public Prodotto findProdottoByautoCompatibile(String autoCompatibile);

    public List<Prodotto> findAllProdottoByautoCompatibile(String autoCompatibile);

}
