package org.scoula.cli;

/**
 * 모든 명령(Command) 클래스가 구현해야 하는 인터페이스입니다.
 */
@FunctionalInterface
public interface Command {
    /**
     * 명령을 실행하는 메서드입니다.
     */
    void execute();
}
