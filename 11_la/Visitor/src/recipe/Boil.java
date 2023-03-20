package recipe;

import ingredient.Acceptor;

public class Boil implements Visitor {
    public void visit(Acceptor acceptor) {
        System.out.println("Starting art ...");
        System.out.println("물을 끓입니다.");
        System.out.println(acceptor.getName() + " " + acceptor.getQuantity()
            + acceptor.getUnit() + "을 물에 넣습니다.");
        System.out.println("건져냅니다.");
    }
}
