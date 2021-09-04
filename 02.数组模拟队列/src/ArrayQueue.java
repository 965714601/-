import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Queue;

/**
 * @author zjw
 * @package DataStructure
 * @Date 2021/9/4
 * @Time 16:07
 */
public class ArrayQueue {
    private  int rear;   //指向队列头部
    private  int front;  //指向队列尾部
    private  int arr[];       // 该数组存放数据，模拟队列
    private int Maxsize;            //队列的大小

    public ArrayQueue(int size){
        this.Maxsize = size;
        rear = -1;
        front = -1;
        arr = new int[size];
    }

   /*判断是否为满*/
    public Boolean isFull(){
        return (rear+1) % Maxsize == front;
    }

    /*判断是否为空*/
    public Boolean isEmpty(){
        return rear == front;
    }

    /*添加数据到队列中*/
    public Boolean addQueue(int number){
        if (isFull())
            return false;
        //System.out.println("rear" + rear);
        rear++;
        arr[rear % Maxsize] = number;
        return true;
    }

    /*出队列操作*/
    public Integer getQueue(){
        if (isEmpty())
            return null;

        int number = arr[++front % Maxsize];
        arr[front] = 0;
        return number;
    }

    /*显示队列的头数据*/
    public int headQueue(){
        if (isEmpty()){
            new RuntimeException("队列为空，不能显示队列头部数据");
        }
        return arr[front+1];
    }

    /*显示队列情况*/
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列已空");
            return;
        }

        for (int i = front+1; rear != i; i++) {
            i = i % Maxsize;
            System.out.print(arr[i] + "\t");
        }
        System.out.print(arr[rear] + "\t");
        System.out.print("\n");
    }
}
