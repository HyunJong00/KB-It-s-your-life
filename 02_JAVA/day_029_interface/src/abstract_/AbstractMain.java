package day_029_interface.src.abstract_;

public class AbstractMain extends AbstractTest {
    @Override
    public void setName(String name) {
        super.name=name;
        //1. 나의 this 2.부모의 this?
    }

    public static void main(String[] args) {
        AbstractTest at = new AbstractMain();
        at.setName("홍길동");
        System.out.println(at.getName());

    }


}