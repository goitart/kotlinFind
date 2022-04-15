import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.File


class Test {
    @Test
    fun startTest1() {
        assertEquals(
            setOf<String>(),
            start(false, File("").absolutePath.toString(), "file3.txt")
        )

        assertEquals(
            setOf("file2.txt"),
            start(false, (File("").absolutePath.toString() + "\\src\\test\\files"), "file2.txt")
        )

        assertEquals(
            setOf<String>(),
            start(true, File("").absolutePath.toString(), "file3.txt")
        )

        assertEquals(
            setOf<String>(),
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

        assertEquals(
            setOf(File("").absolutePath.toString() + "\\src\\test\\files\\subDir\\not found.txt"),
            start(true, File("").absolutePath.toString(), "not found.txt")
        )
    }
}
