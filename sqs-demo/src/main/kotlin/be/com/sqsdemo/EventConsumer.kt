package be.com.sqsdemo

import io.awspring.cloud.sqs.annotation.SqsListener
import org.springframework.messaging.handler.annotation.Header
import org.springframework.stereotype.Component

@Component
class EventConsumer {
    @SqsListener("test-queue")
    fun consumeEvent(
            event: String,
            @Header("ApproximateReceiveCount") receiveCount: Int?): String {
        println("Consuming event: $event , receiveCount: $receiveCount")
        return "Event consumed"
    }
}