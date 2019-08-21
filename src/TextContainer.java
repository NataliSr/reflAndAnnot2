import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@SaveTo(path = "C:\\Users\\1\\IdeaProjects\\Refl2\\text.txt")
public class TextContainer {
    private String text = "Hello Java";

    public TextContainer() {
    }

    @Saver
    public void save(String path) throws IOException {
        try (PrintWriter writer = new PrintWriter(path)) {
            writer.println(text);
        } catch (IOException e) {
            throw e;

        }
    }
}
