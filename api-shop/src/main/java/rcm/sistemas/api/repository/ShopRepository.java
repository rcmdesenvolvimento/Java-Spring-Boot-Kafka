package rcm.sistemas.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rcm.sistemas.api.model.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {

	public Shop findByIdentifier(String identifier);

}
