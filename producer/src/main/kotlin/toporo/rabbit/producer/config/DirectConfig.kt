package toporo.rabbit.producer.config

import org.springframework.amqp.core.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DirectConfig(
    private val firstQueue: Queue,
    private val secondQueue: Queue
) {
    @Bean
    fun directExchange(): Exchange {
        return ExchangeBuilder
            .directExchange("DIRECT-EXCHANGE-BASIC")
            .durable(true)
            .build()
    }

    @Bean
    fun firstDirectBinding(): Binding {
        return BindingBuilder
            .bind(firstQueue)
            .to(directExchange())
            .with("TO-FIRST-QUEUE")
            .noargs()
    }

    @Bean
    fun secondDirectBinding(): Binding {
        return BindingBuilder
            .bind(secondQueue)
            .to(directExchange())
            .with("TO-SECOND-QUEUE")
            .noargs()
    }
}