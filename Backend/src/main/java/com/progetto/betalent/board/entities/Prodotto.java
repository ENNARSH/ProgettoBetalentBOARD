package com.progetto.betalent.board.entities;




import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
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


}

