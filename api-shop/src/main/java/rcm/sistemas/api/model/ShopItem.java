package rcm.sistemas.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import rcm.sistemas.api.dto.ShopItemDTO;

@Getter
@Setter
@Entity
@Table(name = "shop_item")
public class ShopItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "product_identifier")
	private String productIdentifier;

	private Integer amount;

	private Float price;

	@ManyToOne
	@JoinColumn(name = "shop_id")
	private Shop shop;

	public static ShopItem convert(ShopItemDTO shopItemDTO) {
		ShopItem shopItem = new ShopItem();
		shopItem.setProductIdentifier(shopItemDTO.getProductIdentifier());
		shopItem.setAmount(shopItemDTO.getAmount());
		shopItem.setPrice(shopItemDTO.getPrice());
		return shopItem;
	}

}
