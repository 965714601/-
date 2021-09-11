import jdk.nashorn.internal.ir.CallNode;

import java.util.HashSet;

/**
 * @author zjw
 * @package DataStructure
 * @Date 2021/9/9
 * @Time 13:36
 */
public class expression {
    private String s;

    public expression(String s) {
        this.s = s;
    }


    /**
     *
     * 中序表达式转前序表达式      "1+((2+3)*4)-5"
     *
     * (1) 首先构造一个运算符栈(也可放置括号)，运算符(以括号为分界点)在栈内遵循越往栈顶优先级不降低的原则进行排列。
     *
     * (2)从右至左扫描中缀表达式，从右边第一个字符开始判断:
     *
     * 如果当前字符是数字，则分析到数字串的结尾并将数字串直接输出。
     *
     * 如果是运算符，则比较优先级。如果当前运算符的优先级大于等于栈顶运算符的优先级(当栈顶是括号时，直接入栈)，则将运算符直接入栈;否则将栈顶运算符出栈并输出，直到当前运算符的优先级大于等于栈顶运算符的优先级(当栈顶是括号时，直接入栈)，再将当前运算符入栈。
     *
     * 如果是括号，则根据括号的方向进行处理。如果是向右的括号，则直接入栈;否则，遇向左的括号前将所有的运算符全部出栈并输出，遇右括号后将向左、向右的两括号一起出栈(并不输出)。
     *
     * (3) 重复上述操作(2)直至扫描结束，将栈内剩余运算符全部出栈并输出，再逆缀输出字符串。中缀表达式也就转换为前缀表达式了。
     * */

    public String toPrefix() {

        ArrayStack<Character> arrayStack = new ArrayStack<>(Character.class, s.length());
        StringBuilder sb = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {

            if (s.charAt(i) == ')'){
               arrayStack.push(s.charAt(i));
           }

           if (s.charAt(i) =='('){
               if (!arrayStack.isEmpty()){
                   while(arrayStack.getPop() != ')'){
                       sb.append(arrayStack.pop());
                   }
                   arrayStack.pop();
               }
           }

            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                sb.append(s.charAt(i));
            }

            if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                arrayStack.push(s.charAt(i));
            }

            if (s.charAt(i) == '*' || s.charAt(i) == '/') {
                while (arrayStack.getPop() == '+' || arrayStack.getPop() == '-') {
                    sb.append(arrayStack.pop());
                    if (arrayStack.isEmpty())   break;
                }
               arrayStack.push(s.charAt(i));
            }

        }

        while (!arrayStack.isEmpty()){
            sb.append(arrayStack.pop());
        }

        return ""+sb.reverse();
    }


    /**
     * 通过前缀表达式计算结果          -+1*+2345
     * 1、借助中间结果栈tempStack，【从右至左】扫描表达式
     * 2、遇到操作数时，将操作数入tempStack栈
     * 3、遇到操作符时，从tempStack栈中弹出两个操作数，进行运行，然后将运算结果压入tempStack栈。
     * 4、重复1~3，直到pnStack为空
     * 5、tempStack栈剩下的最后一个元素即所求结果
     * @param s 中间结果栈
     * @return
     */
    public Integer calculatePrefix(String s){

        ArrayStack<Integer> arrayStack = new ArrayStack<>(Integer.class, s.length());
        ArrayStack<String> tempStack = new ArrayStack<>(String.class,  s.length());

        for (int i = 0; i < s.length(); i++) {
            tempStack.push(String.valueOf(s.charAt(i)));
        }

        while (!tempStack.isEmpty()){

            String pop = tempStack.getPop();

            if (isNumeric(pop)){
                  arrayStack.push(Integer.parseInt(pop));
                  tempStack.pop();
            }
            else {
                    int a = arrayStack.pop();
                    int b = arrayStack.pop();
                    int calculate = calculate(a, b, tempStack.pop());
                    arrayStack.push(calculate);
            }


        }
        arrayStack.printStack();
        return 0;
    }


    private boolean isNumeric(String s) {
        if (s != null && !"".equals(s.trim()))
            return s.matches("^[0-9]*$");
        else
            return false;
    }

    private int calculate(int a, int b, String character){
        int c = 0;
        switch (character){
            case "-":
                c = a - b;
                break;
            case "+":
                c = a + b;
                break;
            case "*":
                c = a * b;
                break;
            case "/":
                c = a / b;
                break;
            default:
                System.out.println("错误符号，非加减乘除.");
                break;
        }

        return  c;
    }


    /**
     *  前缀转后缀表达式    网址：https://blog.csdn.net/sgbfblog/article/details/8001651
     *
     *  中缀表达式a + b*c + (d * e + f) * g，其转换成后缀表达式则为a b c * + d e * f  + g * +。
     *      "1 + 2*2 + (4 * 1 + 6) * 1" =====>>   122*+41*6+1*+
     * 转换过程需要用到栈，具体过程如下：
     *
     * 1）如果遇到操作数，我们就直接将其输出。
     *
     * 2）如果遇到操作符，则我们将其放入到栈中，遇到左括号时我们也将其放入栈中。
     *
     * 3）如果遇到一个右括号，则将栈元素弹出，将弹出的操作符输出直到遇到左括号为止。注意，左括号只弹出并不输出。
     *
     * 4）如果遇到任何其他的操作符，如（“+”， “*”，“（”）等，从栈中弹出元素直到遇到发现更低优先级的元素(或者栈为空)为止。弹出完这些元素后，才将遇到的操作符压入到栈中。
     * 有一点需要注意，只有在遇到" ) "的情况下我们才弹出" ( "，其他情况我们都不会弹出" ( "。
     *
     * 5）如果我们读到了输入的末尾，则将栈中所有元素依次弹出。
     * */

    public String toSuffix(){

        ArrayStack<String> arrayStack = new ArrayStack<>(String.class, s.length());
        StringBuilder sb = new StringBuilder();
        //int flag = 0;   //左括号的数量
        for (int i = 0; i <= s.length() - 1; i++) {

            String value = String.valueOf(this.s.charAt(i));

            if (" ".equals(value))  continue;

            //如果是数字直接输出到字符串中
            if (isNumeric(value)){
                sb.append(s.charAt(i));
            }
            //如果不是数字直接压入栈中
            else {
                //栈空
                if (arrayStack.isEmpty()){
                    arrayStack.push(value);
                }
                //栈不空
                else {
                    //如果操作数为"("
                    if (value.equals("("))
                        arrayStack.push(value);
                    //如果操作数为")"
                    else if(value.equals(")")){
                            while (!arrayStack.getPop().equals("("))
                                sb.append(arrayStack.pop());
                            if (arrayStack.getPop().equals("("))
                                arrayStack.pop();
                    }
                    else {
                        //比较栈顶操作数和读到的操作数
                        while (true){

                            if (arrayStack.isEmpty())
                                break;

                            if (arrayStack.getPop().equals("("))
                                break;

                            if (compareAB(value,arrayStack.getPop()))
                                break;
                            else
                                sb.append(arrayStack.pop());

                        }
                        arrayStack.push(value);
                    }
                }
            }
        }

        while (!arrayStack.isEmpty())
            sb.append(arrayStack.pop());

        return ""+sb;
    }

    /**
     * a 为读到的操作符，b为栈中的操作符
     * */
    private boolean compareAB(String a, String b){
        if ((a.equals("*") || a.equals("/") ) && (b.equals("+") || b.equals("-"))){
            return true;
        }
        else return false;
    }

    /**
     * 计算后缀表达式      例子：122*+41*6+1*+  结果：15
     *
     * 从左至右扫描表达式，遇到数字时，将数字压入堆栈，遇到运算符时，弹出栈顶的两个数，用运算符对它们做相应的计算（次顶元素 和 栈顶元素），
     * 并将结果入栈；重复上述过程直到表达式最右端，最后运算得出的值即为表达式的结果.
     * */
    public Integer calculateSuffix(String s){
        ArrayStack<Integer> arrayStack = new ArrayStack<>(Integer.class, s.length());
        ArrayStack<String> tempStack = new ArrayStack<>(String.class,  s.length());

        for (int i = 0; i < s.length(); i++) {
            String value = String.valueOf(s.charAt(i));
            if (isNumeric(value))
                arrayStack.push(Integer.parseInt(value));
            else {
                int a = arrayStack.pop();
                int b = arrayStack.pop();
                arrayStack.push(calculate(a,b,value));
            }
        }

        return arrayStack.pop();
    }
}
