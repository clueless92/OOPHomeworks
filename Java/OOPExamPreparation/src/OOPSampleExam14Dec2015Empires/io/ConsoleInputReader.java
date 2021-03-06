package OOPSampleExam14Dec2015Empires.io;

import OOPSampleExam14Dec2015Empires.contracts.InputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputReader implements InputReader {

    private final BufferedReader reader;

    public ConsoleInputReader() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String readLine() {
        String line = null;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return line;
    }
}