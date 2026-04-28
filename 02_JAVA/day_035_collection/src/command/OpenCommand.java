package day_035_collection.src.command;

public class OpenCommand implements Command {
    @Override
    public void execute() {
        System.out.println("=============");
        System.out.println("Opening command");
        System.out.println("=============");
        System.out.println();
    }
}
