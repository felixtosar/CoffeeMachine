package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private Scanner scanner;

    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;

    private CoffeeMachine() {
        this.scanner = new Scanner(System.in);
        this.water = 400;
        this.milk = 540;
        this.beans = 120;
        this.cups = 9;
        this.money = 550;
    }

    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine();
        boolean status;
        do {
            status = machine.processAction();
        }
        while (status);
    }

    public void printState() {
        System.out.println("\nThe coffee machine has:\n" +
                String.format("%d of water\n", this.water) +
                String.format("%d of milk\n", this.milk) +
                String.format("%d of coffee beans\n", this.beans) +
                String.format("%d of disposable cups\n", this.cups) +
                String.format("%d of money", this.money));
    }

    private void processBuy() {
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String type = this.scanner.nextLine();

        if (type.equals("back")) {
            return;
        }

        this.buy(Integer.parseInt(type));
    }

    private void processFill() {
        System.out.println("\nWrite how many ml of water do you want to add:");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        int beans = scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int cups = scanner.nextInt();
        scanner.nextLine();
        this.fill(water, milk, beans, cups);

    }

    private void processTake() {
        System.out.println(String.format("\nI gave you $%d", this.money));
        this.money = 0;
    }

    private void fill(int water, int milk, int beans, int cups) {
        this.water += water;
        this.milk += milk;
        this.beans += beans;
        this.cups += cups;
    }

    private void buy(int type) {
        CoffeeSelector coffeeSelector = new CoffeeSelector();
        Coffee coffee = coffeeSelector.getCoffee(type);
        if (coffee != null) {
            String hasEnough = this.hasEnoughSupplies(coffee);
            if (hasEnough == null) {
                System.out.println("I have enough resources, making you a coffee!");
                this.sellCoffee(coffee);
            } else {
                System.out.printf("Sorry, not enough %s!\n", hasEnough);
            }
        }
    }

    public String hasEnoughSupplies(Coffee coffee) {
        if (water < coffee.getWater()) {
            return "water";
        }
        if (milk <= coffee.getMilk()) {
            return "milk";
        }
        if (beans <= coffee.getBeans()) {
            return "coffee beans";
        }
        if (cups < 0) {
            return "disposable cups";
        }

        return null;
    }

    public void sellCoffee(Coffee coffee) {
        this.money += coffee.getPrice();
        this.water -= coffee.getWater();
        this.milk -= coffee.getMilk();
        this.beans -= coffee.getBeans();
        this.cups--;

    }

    public boolean processAction() {
        System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
        String action = this.scanner.nextLine();

        switch (action) {
            case "buy": {
                this.processBuy();
                break;
            }
            case "fill": {
                this.processFill();
                break;
            }
            case "take": {
                this.processTake();
                break;
            }
            case "remaining": {
                this.printState();
                break;
            }
            case "exit": {
                return false;
            }
            default: {
                break;
            }
        }
        return true;
    }
}









