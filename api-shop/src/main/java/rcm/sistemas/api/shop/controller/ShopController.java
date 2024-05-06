package rcm.sistemas.api.shop.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import rcm.sistemas.api.shop.dto.ShopDTO;
import rcm.sistemas.api.shop.model.Shop;
import rcm.sistemas.api.shop.model.ShopItem;
import rcm.sistemas.api.shop.repository.ShopRepository;

@RestController
@RequestMapping("/shop")
@RequiredArgsConstructor
public class ShopController {

	private final ShopRepository shopRepository;
	// private final SendKafkaMessage sendKafkaMessage;

	@GetMapping
	public List<ShopDTO> getShop() {
		return shopRepository.findAll().stream().map(shop -> ShopDTO.convert(shop)).collect(Collectors.toList());
	}

	@PostMapping
	public ShopDTO saveShop(@RequestBody ShopDTO shopDTO) {
		shopDTO.setIdentifier(UUID.randomUUID().toString());
		shopDTO.setDateShop(LocalDate.now());
		shopDTO.setStatus("PENDING");

		Shop shop = Shop.convert(shopDTO);
		for (ShopItem shopItem : shop.getItems()) {
			shopItem.setShop(shop);
		}

		shopDTO = ShopDTO.convert(shopRepository.save(shop));
		//sendKafkaMessage.sendMessage(shopDTO);
		return shopDTO;

	}

}
