package day_031_try_catch.src.reflection;
class Test{
    private final String id = " 딸기 ";
}
public class ObjectMain {
    public static void main(String[] args) {
        Test t =  new Test();
        System.out.println(t);
        System.out.println(t);
        System.out.println(t.hashCode());

        String str = "apple";
        System.out.println("object= " + str);

        Object aa = new Object();
        Object bb = new Object();
        System.out.println(aa == bb);
        System.out.println(aa.equals(bb));

        Object cc = new String ("apple");
        Object dd = new String ("apple");
        System.out.println(cc == dd);
        System.out.println(cc.equals(dd));
    }

}
