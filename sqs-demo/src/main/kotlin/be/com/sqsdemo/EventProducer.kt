package be.com.sqsdemo

import io.awspring.cloud.sqs.operations.SqsTemplate
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
}
