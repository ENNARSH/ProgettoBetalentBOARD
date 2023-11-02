package com.progetto.betalent.board.entities;





//import org.hibernate.mapping.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
		import jakarta.persistence.Table;

@Entity  //Questa classe corrisponde a una tabella
@Table(name="prodotti") //corrisponde al nome della tabella (entità)
public class Prodotto {
	
	@Id  // Obbligatorio
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //ID incrementale su tutta la tabella
	@Column(name = "id")  //corrisponde al nome della colonna (attributo)
	private Long idProdotto;

	@Column(name = "cod_prodotto") //nisqasmk1fensx12
	private String codProdotto;

	@Column(name = "tipo") // fendinebbia sx
	private String tipo;

	@Column(name = "codici") // 0265809118
	private String codici;

	@Column(name = "auto_compatibile") // qashqai mk1
    private String autoCompatibile;

	@Column(name = "descrizione") // scassato
	private String descrizione;

	@Column(name = "prezzo") // 39
	private Long prezzo;



	public Prodotto() {
		super();
	}
	
    // Getters e Setters


	public Long getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(Long idProdotto) {
		this.idProdotto = idProdotto;
	}

	public String getCodProdotto() {
		return codProdotto;
	}

	public void setCodProdotto(String codProdotto) {
		this.codProdotto = codProdotto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCodici() {
		return codici;
	}

	public void setCodici(String codici) {
		this.codici = codici;
	}

	public String getAutoCompatibile() {
		return autoCompatibile;
	}

	public void setAutoCompatibile(String autoCompatibile) {
		this.autoCompatibile = autoCompatibile;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Long getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Long prezzo) {
		this.prezzo = prezzo;
	}
}
	

