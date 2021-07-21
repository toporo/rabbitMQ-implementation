package toporo.rabbit.consumer.config

import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.listener.MessageListenerContainer
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import toporo.rabbit.consumer.service.BasicListener

@Configuration
class ConsumerConfig(
    private val connectionFactory: ConnectionFactory,
    private val basicListener: BasicListener,
    private val simpleRabbitListenerContainerFactory: SimpleRabbitListenerContainerFactory
) {

    @Bean
    fun listenerContainer(): MessageListenerContainer {
        val container = SimpleMessageListenerContainer()
        container.connectionFactory = connectionFactory
        container.setQueueNames("SECOND-QUEUE-BASIC")
        container.setMessageListener(basicListener)
        simpleRabbitListenerContainerFactory.adviceChain?.let {
            container.setAdviceChain(*it)
        }

        return container
    }
}