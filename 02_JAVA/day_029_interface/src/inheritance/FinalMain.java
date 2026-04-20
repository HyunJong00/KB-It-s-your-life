package day_029_interface.src.inheritance;
enum ColorEnum{ RED, GREEN, BLUE}
class Final {

    public final String FRUIT = "사과";
    public final String FRUIT2;
    public static final String ANIMAL = "호랑이";
    public static final String ANIMAL2;

    Final(String FRUIT2){
        this.FRUIT2=FRUIT2;
    }
//    Final(){};
    static{
        ANIMAL2 = "기린";
    }
}
public class FinalMain{
    public static void main(String[] args) {
        System.out.println("빨강 = " + ColorEnum.RED);
        System.out.println("초록 = " + ColorEnum.GREEN.ordinal());

        for(ColorEnum color : ColorEnum.values()) {
            System.out.println(color.ordinal());
            }

        Final f  = new Final("딸기");
        System.out.println("ANIMAL = " + Final.ANIMAL);
        System.out.println("FRUIT = " +f.FRUIT);

    }
}