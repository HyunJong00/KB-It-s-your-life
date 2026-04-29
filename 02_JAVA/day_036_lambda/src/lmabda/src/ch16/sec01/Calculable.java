package ch16.sec01;

//어노테이션으로 함수형 인터페이스 명시
@FunctionalInterface
public interface Calculable {
    void calculate(int x, int y);
}
