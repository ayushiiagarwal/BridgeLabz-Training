import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileProcessorTest {
    FileProcessor processor = new FileProcessor();
    String filename = "example.txt";
    String content = "Testing File Handling Methods";

    @Test
    void testWriteAndReadFile() throws IOException {
        processor.writeToFile(filename, content);
        String result = processor.readFromFile(filename);
        assertEquals(content, result);
    }

    @Test
    void testFileExistsAfterWrite() throws IOException {
        processor.writeToFile(filename, content);
        assertTrue(Files.exists(Path.of(filename)));
    }

    @Test
    void testReadNonExistingFile() {
        assertThrows(IOException.class, () -> {
            processor.readFromFile("file.txt");
        });
    }
}