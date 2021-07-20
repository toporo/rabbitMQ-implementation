package toporo.rabbit.producer.config

import org.springframework.amqp.core.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FanoutConfig(
    private val firstQueue: Queue,
    private val secondQueue: Queue
) {
    @Bean
    fun fanoutExchange(): Exchange {
        return ExchangeBuilder
            .fanoutExchange("FANOUT-EXCHANGE-BASIC")
            .durable(true)
            .build()
    }

    @Bean
    fun firstFanoutBinding(): Binding {
        return BindingBuilder
            .bind(firstQueue)
            .to(fanoutExchange())
            .with("")
            .noargs()
    }

    @Bean
    fun secondFanoutBinding(): Binding {
        return BindingBuilder
            .bind(secondQueue)
            .to(fanoutExchange())
            .with("")
            .noargs()
    }
}