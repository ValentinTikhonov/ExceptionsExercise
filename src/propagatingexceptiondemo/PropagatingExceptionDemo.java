package propagatingexceptiondemo;

import java.io.IOException;

public class PropagatingExceptionDemo {
    public static void main(String[] args) {
        ExceptionGenerator generator = new ExceptionGenerator();

        try {
            generator.MethodOne();
        } catch (Exception e) {
            System.out.println("Caugh exception: " + e);
        }
    }
}
