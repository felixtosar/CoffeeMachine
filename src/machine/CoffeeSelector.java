package machine;

public class CoffeeSelector {
    public Coffee getCoffee(int type) {
        switch (type) {
            case 1:
                return new EspressoCoffee();
            case 2:
                return new LatteCoffee();
            case 3:
                return new CappuccinoCoffee();
            default:
                return null;
        }
    }
}
