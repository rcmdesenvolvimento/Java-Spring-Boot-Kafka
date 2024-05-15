package rcm.sistemas.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import rcm.sistemas.api.model.ShopReport;

@Repository
public interface ShopReportRepository extends JpaRepository<ShopReport, Long> {

	@Modifying
	@Query(value = "update shop_report s set s.amount = s.amount + 1 "
       			 + "where s.identifier = :shopStatus", nativeQuery = true)
	void incrementShopStatus(@Param(value = "shopStatus") String shopStatus);
}
