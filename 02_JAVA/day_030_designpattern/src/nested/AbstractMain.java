package day_030_designpattern.src.nested;

public class AbstractMain {

    public static void main(String[] args) {
        AbstractTest at =  new AbstractTest(){
            public void setName(String name) {
                this.name = name;
            }
        };
        at.setName("홍길동");
        System.out.println(at.getName());

        InterA a = new InterA(){
            public void aa(){}
            public void bb(){}
        };

        AbstractExam abstractExam = new AbstractExam() {

        };
    }
}
