package OOPSampleExam07Dec2015;

import OOPSampleExam07Dec2015.Commands.*;
import OOPSampleExam07Dec2015.Interfaces.Database;
import OOPSampleExam07Dec2015.Interfaces.Executable;
import OOPSampleExam07Dec2015.Interfaces.Runnable;

public class CapitalistEngine implements Runnable {
    private Database db;

    public CapitalistEngine(Database db)
    {
        this.db = db;
    }

    @Override
    public void run() {
        Executable command = null;
        String line = TerminalIO.readln();
        while (!line.equals("end")) {
            String[] tokens = line.split(" ");
            switch (tokens[0]) {
                case "create-company":
                    command = new CreateCompanyCommand(db, tokens[1], tokens[2],
                            tokens[3], Double.parseDouble(tokens[4]));
                    break;
                case "create-employee":
                    String departmentName = null;
                    if (tokens.length > 5) {
                        departmentName = tokens[5];
                    }
                    command = new CreateEmployeeCommand(db, tokens[1], tokens[2],
                            tokens[3], tokens[4], departmentName);
                    break;
                case "create-department":
                    String mainDepartmentName = null;
                    if (tokens.length > 5) {
                        mainDepartmentName = tokens[5];
                    }
                    command = new CreateDepartmentCommand(db, tokens[1], tokens[2],
                            tokens[3],tokens[4], mainDepartmentName);
                    break;
                case "pay-salaries":
                    command = new PaySalariesCommand(tokens[1], db);
                    break;
                case "show-employees":
                    command = new ShowEmployeesCommand(tokens[1], db);
                    break;
            }
            try {
                if (command != null) {
                    TerminalIO.print(command.execute());
                }
            }
            catch (Exception e) {
                TerminalIO.println(e.getMessage());
            }
            finally {
                line = TerminalIO.readln();
            }
        }
    }
}
