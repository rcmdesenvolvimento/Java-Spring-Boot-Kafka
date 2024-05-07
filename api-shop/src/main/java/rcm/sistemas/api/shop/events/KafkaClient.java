package rcm.sistemas.api.shop.events;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import rcm.sistemas.api.shop.dto.ShopDTO;

@Service
@RequiredArgsConstructor
public class KafkaClient {

	private final KafkaTemplate<String, ShopDTO> kafkaTemplate;

	private static final String SHOP_TOPIC_NAME = "SHOP_TOPIC";

	public void sendMessage(ShopDTO msg) {
		kafkaTemplate.send(SHOP_TOPIC_NAME, msg.getBuyerIdentifier(), msg);
	}

}
