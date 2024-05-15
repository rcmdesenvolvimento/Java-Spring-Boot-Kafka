package rcm.sistemas.api.events;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import rcm.sistemas.api.dto.ShopDTO;
import rcm.sistemas.api.dto.ShopItemDTO;
import rcm.sistemas.api.model.Product;
import rcm.sistemas.api.repository.ProductRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReceiveKafkaMessage {

	private static final String SHOP_TOPIC_NAME = "SHOP_TOPIC";
	private static final String SHOP_TOPIC_EVENT_NAME = "SHOP_TOPIC_EVENT";

	private final ProductRepository productRepository;

	private final KafkaTemplate<String, ShopDTO> kafkaTemplate;

	@KafkaListener(topics = SHOP_TOPIC_NAME, groupId = "group")
	public void listenShopTopic(ShopDTO shopDTO) {
		
		log.info("Compra recebida no tópico: {}", shopDTO.getIdentifier());
		
		boolean success = true;
		for (ShopItemDTO item : shopDTO.getItems()) {
			
			String _productIdentifier = item.getProductIdentifier();
			System.out.println("Lendo o produto : " + _productIdentifier );
			
			Product product = productRepository.findByIdentifier(item.getProductIdentifier());
			
			if (!isValidShop(item, product)) {
				shopError(shopDTO);
				System.out.println("Erro lendo o produto : " + shopDTO.getIdentifier());
				success = false;
				break;
			}
		}
		if (success) {
			shopSuccess(shopDTO);
			System.out.println("Compra efetuada com sucesso : " + shopDTO.getIdentifier());
		}

	}

	// valida se a compra possui algum erro
	private boolean isValidShop(ShopItemDTO item, Product product) {
		return product != null && product.getAmount() >= item.getAmount();
	}

	private void shopError(ShopDTO shopDTO) {
		log.info("Erro no processamento da compra {}.", shopDTO.getIdentifier());
		shopDTO.setStatus("ERROR");
		kafkaTemplate.send(SHOP_TOPIC_EVENT_NAME, shopDTO);
	}

	private void shopSuccess(ShopDTO shopDTO) {
		log.info("Compra {} efetuada com sucesso.", shopDTO.getIdentifier());
		shopDTO.setStatus("SUCCESS");
		kafkaTemplate.send(SHOP_TOPIC_EVENT_NAME, shopDTO);
	}

}
