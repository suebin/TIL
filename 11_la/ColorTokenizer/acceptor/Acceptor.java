package acceptor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import visitor.Visitor;

public abstract class Acceptor {
    protected String fileName;
    protected List<String> fileContents;

    public Acceptor(String fileName) {
        this.fileName = fileName;
        this.fileContents = new ArrayList<>();
        readFileContents();
    }

    public String getName() {
        return this.fileName;
    }

    public List<String> getFileContents() {
        return this.fileContents;
    }

    public void setFileContents(List<String> fileContents) {
        this.fileContents = fileContents;
    }

    public void readFileContents() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                fileContents.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract void accept(Visitor visit);
}
