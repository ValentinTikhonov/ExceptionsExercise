package propagatingexceptiondemo;

import java.io.IOException;

public class ExceptionGenerator {
    public void MethodOne() throws IOException, ClassNotFoundException {
        MethodTwo();
        throw new IOException( "Hello from method 1");
    }

    private void MethodTwo() throws IllegalArgumentException, ClassNotFoundException {

        MethodThree();
        throw new IllegalArgumentException( "Hello from method 2");
    }

    private void MethodThree() throws ArithmeticException, ClassNotFoundException {
        MethodFour();
        throw new ArithmeticException( "Hello from method 3");
    }

    private void MethodFour() throws ClassNotFoundException{
        MethodFive();
        throw new ClassNotFoundException( "Hello from method 4");
    }

    private void MethodFive() throws NullPointerException {

     //   throw new NullPointerException( "Hello from method 5");
        /*int[] myIntArray = new int[5];
        myIntArray[5] = 25;*/
    }
}
