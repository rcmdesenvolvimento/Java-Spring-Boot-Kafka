package rcm.sistemas.api.model;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import rcm.sistemas.api.dto.ShopDTO;

@Getter
@Setter
@Entity
@Table(name = "shop")
public class Shop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String identifier;

	private String status;

	@Column(name = "date_shop")
	private LocalDate dateShop;

	@Column(name = "buyer_identifier")
	private String buyerIdentifier;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "shop")
	private List<ShopItem> items;

	public static Shop convert(ShopDTO shopDTO) {
		Shop shop = new Shop();
		shop.setIdentifier(shopDTO.getIdentifier());
		shop.setStatus(shopDTO.getStatus());
		shop.setDateShop(shopDTO.getDateShop());
		shop.setItems(shopDTO.getItems().stream().map(i -> ShopItem.convert(i)).collect(Collectors.toList()));
		shop.setBuyerIdentifier(shopDTO.getBuyerIdentifier());
		return shop;
	}

}
