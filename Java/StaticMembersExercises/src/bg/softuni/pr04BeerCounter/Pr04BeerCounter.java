package bg.softuni.pr04BeerCounter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BeerCounter {
    static int beersInStock;
    static int beersDrunkCount;

    static {
        beersInStock = 0;
        beersDrunkCount = 0;
    }

    public static void BuyBeer(int beerBottlesCount) {
        beersInStock += beerBottlesCount;
    }

    public static void DrinkBeer(int beerBottlesCount) {
        beersDrunkCount += beerBottlesCount;
        beersInStock -= beerBottlesCount;
    }
}

public class Pr04BeerCounter {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command = reader.readLine();
        while(!command.equals("End")) {
            String[] beersString = command.split(" ");
            int[] beers = new int[beersString.length];
            for (int i = 0; i < beers.length; i++) {
                beers[i] = Integer.parseInt(beersString[i]);
            }

            int beersInStock = beers[0];
            int beersToDrink = beers[1];

            BeerCounter.BuyBeer(beersInStock);
            BeerCounter.DrinkBeer(beersToDrink);

            command = reader.readLine();
        }
        System.out.println(BeerCounter.beersInStock+" "+BeerCounter.beersDrunkCount);
    }
}
