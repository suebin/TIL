package visitor;

import acceptor.Acceptor;
import java.util.List;

public class PaintSymbol implements Visitor {
    @Override
    public void visit(Acceptor acceptor) {
        List<String> fileContents = acceptor.getFileContents();

        int index = 0;
        for (String line : fileContents) {
            fileContents.set(index++, (line.replaceAll("([^a-zA-Z0-9/=/-/+/*//\s])",
                    "<font color='red'>$0</font>")));
        }

        index = 0;
        for (String line : fileContents) {
            fileContents.set(index++, (line.replaceAll("(?![^<]*>)\s",
                    "&nbsp;&nbsp;&nbsp;&nbsp;")));
        }

        acceptor.setFileContents(fileContents);
    }
}
