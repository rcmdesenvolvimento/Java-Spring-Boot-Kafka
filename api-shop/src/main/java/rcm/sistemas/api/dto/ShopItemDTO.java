package rcm.sistemas.api.dto;

import lombok.Getter;
import lombok.Setter;
import rcm.sistemas.api.model.ShopItem;

@Getter
@Setter
public class ShopItemDTO {

	private String productIdentifier;
	private Integer amount;
	private Float price;

	public static ShopItemDTO convert(ShopItem shopItem) {
		ShopItemDTO shopItemDTO = new ShopItemDTO();
		shopItemDTO.setProductIdentifier(shopItem.getProductIdentifier());
		shopItemDTO.setAmount(shopItem.getAmount());
		shopItemDTO.setPrice(shopItem.getPrice());
		return shopItemDTO;
	}

}
