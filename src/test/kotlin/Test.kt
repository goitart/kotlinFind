
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Test {

    @Test
    fun startTestSub() {
        assertEquals(setOf("C:\\Users\\chevy\\IdeaProjects\\kotlinFind\\src\\test\\files\\file1.txt"),
            start(true,"C:\\Users\\chevy\\IdeaProjects\\kotlinFind", "file1.txt"))
    }

    @Test
    fun startTest() {
        assertEquals(setOf("File not found"),
            start(false,"C:\\Users\\chevy\\IdeaProjects\\kotlinFind", "file2.txt"))
    }

    @Test
    fun startTestSub1() {
        assertEquals(setOf("File not found"),
            start(true,"C:\\Users\\chevy\\IdeaProjects\\kotlinFind", "file3.txt"))
    }

    @Test
    fun startTest1() {
        assertEquals(setOf("File not found"),
            start(false,"C:\\Users\\chevy\\IdeaProjects\\kotlinFind", "file3.txt"))
    }

    @Test
    fun startTest2() {
        assertEquals(setOf("C:\\Users\\chevy\\IdeaProjects\\kotlinFind\\src\\test\\files\\file2.txt"),
            start(false,"C:\\Users\\chevy\\IdeaProjects\\kotlinFind\\src\\test\\files", "file2.txt"))
    }
}