package toporo.rabbit.consumer.entitie

import java.time.LocalDate

data class MessageObject (
    val title: String,
    val message: String,
    val createdAt: LocalDate,
)