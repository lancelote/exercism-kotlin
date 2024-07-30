package gigasecond

import java.time.LocalDate
import java.time.LocalDateTime

class Gigasecond(today: LocalDateTime) {
    constructor(today: LocalDate) : this(today.atTime(0, 0))

    val date: LocalDateTime = today.plusSeconds(1_000_000_000)
}
