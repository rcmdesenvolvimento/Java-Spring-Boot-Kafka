package rcm.sistemas.api.dto;

import lombok.Getter;
import lombok.Setter;
import rcm.sistemas.api.model.ShopReport;

@Getter
@Setter
public class ShopReportDTO {

    private String identifier;
    private Integer amount;

    public static ShopReportDTO convert(ShopReport shopReport) {
        ShopReportDTO shopReportDTO = new ShopReportDTO();
        shopReportDTO.setIdentifier(shopReport.getIdentifier());
        shopReportDTO.setAmount(shopReport.getAmount());
        return shopReportDTO;
    }

}


/*
Caused by: org.springframework.messaging.converter.MessageConversionException: Cannot convert from [java.lang.String] to [rcm.sistemas.api.dto.ShopDTO] for GenericMessage [payload={"identifier":"6b41096d-5557-4366-bb28-c37f0b386a1f","dateShop":[2024,5,14],"status":"SUCCESS","buyerIdentifier":null,"items":[{"productIdentifier":"123456789","amount":20,"price":100.0}]}, headers={kafka_offset=4, kafka_consumer=org.springframework.kafka.core.DefaultKafkaConsumerFactory$ExtendedKafkaConsumer@5441ceb0, kafka_timestampType=CREATE_TIME, kafka_receivedPartitionId=0, kafka_receivedTopic=SHOP_TOPIC_EVENT, kafka_receivedTimestamp=1715739409426, __TypeId__=[B@41ae10d9, kafka_groupId=group_report}]
at org.springframework.messaging.handler.annotation.support.PayloadMethodArgumentResolver.resolveArgument(PayloadMethodArgumentResolver.java:151) ~[spring-messaging-6.1.6.jar:6.1.6]
at org.springframework.kafka.annotation.KafkaNullAwarePayloadArgumentResolver.resolveArgument(KafkaNullAwarePayloadArgumentResolver.java:48) ~[spring-kafka-3.1.4.jar:3.1.4]
at org.springframework.messaging.handler.invocation.HandlerMethodArgumentResolverComposite.resolveArgument(HandlerMethodArgumentResolverComposite.java:118) ~[spring-messaging-6.1.6.jar:6.1.6]
at org.springframework.messaging.handler.invocation.InvocableHandlerMethod.getMethodArgumentValues(InvocableHandlerMethod.java:147) ~[spring-messaging-6.1.6.jar:6.1.6]
at org.springframework.messaging.handler.invocation.InvocableHandlerMethod.invoke(InvocableHandlerMethod.java:115) ~[spring-messaging-6.1.6.jar:6.1.6]
at org.springframework.kafka.listener.adapter.HandlerAdapter.invoke(HandlerAdapter.java:56) ~[spring-kafka-3.1.4.jar:3.1.4]
at org.springframework.kafka.listener.adapter.MessagingMessageListenerAdapter.invokeHandler(MessagingMessageListenerAdapter.java:376) ~[spring-kafka-3.1.4.jar:3.1.4]
... 15 common frames omitted
*/