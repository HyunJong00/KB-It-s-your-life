package day_030_designpattern.src.template;

public class StringDisplay extends AbstractDisplay{
    private String s;
    private int width;

    public StringDisplay(String s) {
        this.s = s;
        this.width = s.length();
    }

    private void printLine(){
        System.out.print('+');
        for(int i=0; i<width;i ++){
            System.out.print("-");
        }
        System.out.println("+");
    }
    @Override
    void open() {
        printLine();
    }

    @Override
    void print() {
            System.out.println("|"+s+"|");
    }

    @Override
    void close() {
        printLine();
    }

}
