package acceptor;

import visitor.Visitor;

public class JavaSourceCode extends Acceptor {
    public JavaSourceCode(String fileName) {
        super(fileName);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
