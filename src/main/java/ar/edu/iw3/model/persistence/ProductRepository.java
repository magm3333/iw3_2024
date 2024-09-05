package ar.edu.iw3.model.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.iw3.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	Optional<Product> findByProduct(String product);

	// https://docs.spring.io/spring-data/jpa/reference/jpa/getting-started.html
	Optional<Product> findByProductAndIdNot(String product, long id);
}
