package be.com.sqsdemo

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class EventController(
    private val eventProducer: EventProducer,
) {
    @PostMapping("/event/{eventString}")
    fun produceEvent(
        @PathVariable eventString: String,
    ): String {
        eventProducer.eventProducer(eventString = eventString)
        return "Event produced"
    }

    @PostMapping("/fifo/event/{eventString}")
    fun produceFifoEvent(
        @PathVariable eventString: String,
    ): String {
        eventProducer.eventProducerFifo(eventString = eventString)
        return "Event produced"
    }
}
