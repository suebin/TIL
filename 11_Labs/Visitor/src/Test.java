import ingredient.Pork;
import recipe.Fry;

public class Test {
    public static void main(String[] args) throws Exception {
        Pork pork = new Pork("돼지고기", 200, "g");

        Fry fry = new Fry();
        fry.visit(pork);
        // pork.accept(fry);
    }
}
