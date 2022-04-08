
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Test {
    @Test
    fun start() {
        assertEquals(setOf("C:\\Users\\chevy\\OneDrive\\Документы\\Samsung\\rty.txt", "C:\\Users\\chevy\\OneDrive\\Документы\\SideSync\\rty.txt", "C:\\Users\\chevy\\OneDrive\\Документы\\SideSync\\Notification\\rty.txt"), start(true, true, "C:\\Users\\chevy\\OneDrive\\Документы", "rty.txt"))
    }
}