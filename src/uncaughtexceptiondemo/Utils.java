package uncaughtexceptiondemo;

public class Utils {
    public String doThat(int val){
        String result = (256/val) + "";
        return result;
    }

    public String doThis(String num){
        int intNum = Integer.parseInt(num);
        String result = doThat(intNum);
        return result;
    }
}
