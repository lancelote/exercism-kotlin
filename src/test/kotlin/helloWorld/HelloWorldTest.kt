package helloWorld

import kotlin.test.Test
import kotlin.test.assertEquals

class HelloWorldTest {
    @Test
    fun helloWorldTest() {
        assertEquals("Hello, World!", hello())
    }
}
