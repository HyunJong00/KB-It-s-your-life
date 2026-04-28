package day_035_collection.src.command;

public class PrintCommand implements Command {
    @Override
    public void execute() {
        System.out.println("===========");
        System.out.println("Printing command");
        System.out.println("===========");
        System.out.println();
    }
}
