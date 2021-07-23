package toporo.rabbit.consumer.service

import org.slf4j.LoggerFactory
import org.springframework.amqp.core.Message
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.amqp.support.converter.MessageConverter
import org.springframework.stereotype.Service
import toporo.rabbit.consumer.entitie.MessageObject

@Service
class JsonConsumer {
    /*private val messageConverter: MessageConverter
){
    private val log = LoggerFactory.getLogger(javaClass)

    @RabbitListener(queues = ["JSON-QUEUE-BASIC"])
    fun receiveMessageFromJsonQueue(message: Message) {
        log.info("receive message from ${message.messageProperties.consumerQueue}")
        val person = messageConverter.fromMessage(message) as MessageObject
        log.info("body $person")
    }*/
}