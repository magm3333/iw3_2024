package ar.edu.iw3.model.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.iw3.model.Product;
import jakarta.transaction.Transactional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	Optional<Product> findByProduct(String product);

	// https://docs.spring.io/spring-data/jpa/reference/jpa/getting-started.html
	Optional<Product> findByProductAndIdNot(String product, long id);
	
	@Query(value="SELECT count(*) FROM products where id_category=?", nativeQuery=true)
	public Integer countProductsByCategory(long idCategory);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE products SET stock=? WHERE id=?", nativeQuery=true)
	public int setStock(boolean stock, long idProduct);

}
