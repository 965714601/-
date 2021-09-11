/**
 * @author zjw
 * @package DataStructure
 * @Date 2021/9/10
 * @Time 14:55
 */
public class test {
    public static void main(String[] args) {
        int number = 20;
        char cNumber= (char) (number+'0');
        System.out.println("Number "+number+" to char is:"+cNumber);

        int num = Integer.parseInt(String.valueOf(cNumber));
        System.out.println(num);
    }
}
