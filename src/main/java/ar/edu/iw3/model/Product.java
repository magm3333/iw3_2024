package ar.edu.iw3.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 100, unique = true)
	private String product;

	@Column(columnDefinition = "tinyint default 1")
	private boolean stock = true;

	private double price;
	
	@ManyToOne
	@JoinColumn(name = "id_category", nullable = true)
	private Category category	;
	
	
	@Override
	public String toString() {
		return String.format("id=%s, product=%s, precio=%s, stock=%s ", this.getId(), this.getProduct(), this.getPrice(), this.isStock());
	}
}
