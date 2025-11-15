package be.com.sqsdemo

import io.awspring.cloud.sqs.operations.SqsTemplate
import java.util.function.Consumer
import org.springframework.stereotype.Service

@Service
class EventProducer(
    private val sqsTemplate: SqsTemplate,
) {

    fun eventProducer(eventString: String): String {
        val test = sqsTemplate.send<String>("test-queue", eventString)

        println(test)
        return "Event produced"
    }

    fun eventProducerFifo(eventString: String): String {
        val test1 = sqsTemplate.send<String> { to ->
            to.queue("test-queue.fifo")
            to.messageGroupId("group1")
            to.payload(eventString)
            to.messageDeduplicationId(System.currentTimeMillis().toString())
        }
        println(test1)

        val test =sqsTemplate.send<String> {
            it.queue("test-queue.fifo")
            it.messageGroupId("group1")
                .payload(eventString + "EVENT!!!!!")
//            it.queueName("test-queue.fifo")
//            it.messageBody(eventString)
            it.messageDeduplicationId(System.currentTimeMillis().toString())
        }

        println(test)
        return "FIFO Event produced"
    }
}
