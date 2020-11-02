package tw.leonchen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "stockTransaction")
public class StockTransaction {

	private int id;
	private int tradevolume;
	private Stock stock;

	@Id
	@Column(name = "STOCKTRANSID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "TRADEVOLUME")
	public int getTradevolume() {
		return tradevolume;
	}

	public void setTradevolume(int tradevolume) {
		this.tradevolume = tradevolume;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STOCKID")
	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}
}
