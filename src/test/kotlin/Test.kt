import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.File


class Test {
    @Test
    fun startTest1() {
        assertEquals(
            setOf("File not found"),
            start(false, File("").absolutePath.toString(), "file3.txt")
        )

        assertEquals(
            setOf(File("").absolutePath.toString() + "\\src\\test\\files\\file2.txt"),
            start(false, (File("").absolutePath.toString() + "\\src\\test\\files"), "file2.txt")
        )

        assertEquals(
            setOf("File not found"),
            start(true, File("").absolutePath.toString(), "file3.txt")
        )

        assertEquals(
            setOf("File not found"),
            start(false, File("").absolutePath.toString(), "file2.txt")
        )

        assertEquals(
            setOf(File("").absolutePath.toString() + "\\src\\test\\files\\file1.txt"),
            start(true, File("").absolutePath.toString(), "file1.txt")
        )

        assertEquals(
            setOf(File("").absolutePath.toString() + "\\src\\test\\files\\file1.txt"),
            start(true, File("").absolutePath.toString(), "file1.txt")
        )
    }
}
