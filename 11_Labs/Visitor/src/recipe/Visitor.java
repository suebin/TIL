package recipe;

import ingredient.Acceptor;

public interface Visitor {
    void visit(Acceptor acceptor);
}