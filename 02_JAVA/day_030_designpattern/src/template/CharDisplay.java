package day_030_designpattern.src.template;


public class CharDisplay extends AbstractDisplay {
    private char ch;

    // 위부에서 주입 (DI)
    public CharDisplay(char ch) {
        this.ch = ch;
    }

    @Override
    void open() {
        System.out.print("<<");
    }

    @Override
    void print() {
        System.out.print(ch);
    }

    @Override
    void close() {
        System.out.println(">>");

    }
}
