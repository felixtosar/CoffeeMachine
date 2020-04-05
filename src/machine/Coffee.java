package machine;

public abstract class Coffee {
    protected int water;
    protected int milk;
    protected int coffeeBeans;
    protected int price;

    public Coffee(int water, int milk, int coffeeBeans, int price) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.price = price;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getBeans() {
        return coffeeBeans;
    }

    public int getPrice() {
        return price;
    }
}
