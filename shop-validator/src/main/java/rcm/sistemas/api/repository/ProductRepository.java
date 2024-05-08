package rcm.sistemas.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rcm.sistemas.api.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	Product findByIdentifier(String identifier);

}
