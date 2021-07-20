package toporo.rabbit.producer.controllers

import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.http.HttpEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import toporo.rabbit.producer.entities.Message

@RestController
@RequestMapping("exchanges")
class ExchangeController(
    private val rabbitTemplate: RabbitTemplate
) {

    private val log = LoggerFactory.getLogger(javaClass)

    @PostMapping("{exchange}/{routingKey}")
    fun postOnExchange(
        @PathVariable exchange: String,
        @PathVariable routingKey: String,
        @RequestBody message: String
    ): HttpEntity<Any?> {
        log.info("sending message $message")
        rabbitTemplate.convertAndSend(exchange, routingKey, message)
        return ResponseEntity.ok().build()
    }

    @PostMapping("json/{exchange}/{routingKey}")
    fun postJsonOnExchange(
        @PathVariable exchange: String,
        @PathVariable routingKey: String,
        @RequestBody message: Message
    ): HttpEntity<Any?> {
        log.info("sending message $message")
        rabbitTemplate.convertAndSend(exchange, routingKey, message)
        return ResponseEntity.ok().build()
    }
}