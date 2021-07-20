package toporo.rabbit.producer.entities

import java.time.LocalDate

data class Message (
    val title: String,
    val message: String,
    val createdAt: LocalDate,
)