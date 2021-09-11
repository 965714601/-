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

}
