import BevrageSystem.Barista;
import BevrageSystem.BeverageBuilder;
import BevrageSystem.CoffeeMaker;

public class Main {
    public static void main(String[] args) {
        Barista barista = new Barista();
        BeverageBuilder beverageBuilder = new CoffeeMaker();

        barista.setBeveragebuilder(beverageBuilder);
        barista.brew();

        System.out.println(barista.getBeverage());
    }
}
