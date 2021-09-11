import com.sun.org.apache.xpath.internal.operations.Bool;

import java.lang.reflect.Array;

/**
 * @author zjw
 * @package DataStructure
 * @Date 2021/9/7
 * @Time 14:42
 */
public class ArrayStack<T> {
    private int MaxSize;    //栈大小
    private T stack[];    //栈数组
    private  int pop = -1;    //栈顶

    public ArrayStack(Class<T> componentType, int maxSize) {
        this.MaxSize = maxSize;
        stack = (T[]) Array.newInstance(componentType,MaxSize);
    }



    /**
     *  进栈
     * */
    public boolean push(T n){
        if (pop == MaxSize - 1){
            System.out.println("栈满。。。");
            return false;
        }

        pop++;
        stack[pop] = n;
        return true;
    }


    /**
     * 出栈
     * */
    public T pop(){

        if (pop == -1){
            System.out.println("栈空。。。");
            return null;
        }
        T temp = stack[pop];
        stack[pop] = null;
        pop--;

        return temp;
    }


    /**
     * 获取栈顶
     * */
    public T getPop(){
        if (pop == -1){
            System.out.println("栈空。。。");
            return null;
        }
        return stack[pop];
    }

    /**
     * 判断栈是否为空
     * */
    public Boolean isEmpty(){
        return pop== -1;
    }

    /**
     *  打印栈
     * */

    public void printStack(){
        int j = 0;
        while(j != pop+1){
            System.out.print(stack[j]);
            j++;
        }
        System.out.println();
    }

    /**
     *  清空栈
     * */
    public void clean(){
        while (pop != -1){
            stack[pop] = null;
            pop--;
        }
    }

    public int hasNumber(){
        return pop;
    }

}
