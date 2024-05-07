package rcm.sistemas.shop.validator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rcm.sistemas.shop.validator.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	Product findByIdentifier(String identifier);

}
