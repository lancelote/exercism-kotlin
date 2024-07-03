package helloWorld

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class HelloWorldTest {
    @Test
    fun helloWorldTest() {
        assertEquals("Hello, World!", hello())
    }
}
