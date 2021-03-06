package toporo.rabbit.producer.config

import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.QueueBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class QueueConfig {
    @Bean
    fun firstQueue(): Queue {
        return QueueBuilder
            .durable("FIRST-QUEUE-BASIC")
            .build()
    }

    @Bean
    fun secondQueue(): Queue {
        return QueueBuilder
            .durable("SECOND-QUEUE-BASIC")
            .build()
    }
}