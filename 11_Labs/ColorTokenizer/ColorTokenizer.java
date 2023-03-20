import acceptor.JavaSourceCode;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import visitor.PaintKeyword;
import visitor.PaintSymbol;

public class ColorTokenizer {
    public static void main(String[] args) {
        String fileName = args[0];
        JavaSourceCode code = new JavaSourceCode(fileName);

        PaintSymbol paintSymbol = new PaintSymbol();
        PaintKeyword paintKeyword = new PaintKeyword();

        paintSymbol.visit(code);
        paintKeyword.visit(code);

        try {
            File file = new File(fileName.substring(0, fileName.length() - 5) + ".html");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            for (String line : code.getFileContents()) {
                writer.write(line + "<br>");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
