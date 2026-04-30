package day_037_stream.src.ch18;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {
    public static void main(String[] args) {
        try(OutputStream os = new FileOutputStream("C:temp/test1.db")) {
            byte a = 10;
            byte b = 20;
            byte c = 30; // 타입 변환 없이 사용

            os.write(a);
            os.write(b);
            os.write(c);
            os.flush();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
