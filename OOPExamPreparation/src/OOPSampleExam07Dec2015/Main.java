package OOPSampleExam07Dec2015;

import OOPSampleExam07Dec2015.Interfaces.Database;
import OOPSampleExam07Dec2015.Interfaces.Runnable;

public class Main {
    public static void main(String[] args) {

        Database db = new CapitalistDatabase();
        Runnable capitalistEngine = new CapitalistEngine(db);
        capitalistEngine.run();
    }
}
