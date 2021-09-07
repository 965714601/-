import java.util.Scanner;

/**
 * @author zjw
 * @package DataStructure
 * @Date 2021/9/7
 * @Time 13:17
 */
public class Josephu {

    private static int n;
    private static int m;
    private static LinkedNode[] arr;


    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("共有n人：");
         n = scanner.nextInt();
        System.out.print("数到m的那个人出列: ");
         m = scanner.nextInt();

         initLink();
    }

    /**
     * 初始化链表
     * */
    private void initLink(){

        arr = new LinkedNode[n];

        for (int i = 0; i < n; i++) {
            arr[i]= new LinkedNode<Integer>(i);
        }

        for (int i = 0; i < n; i++) {
            if (i != n - 1){
                arr[i].setNext(arr[i+1]);
            }
        }
        arr[n - 1].setNext(arr[0]);

        printLink();

        System.out.println("------------------------------");
        System.out.println("约瑟夫排序：");
        printOlder();
    }

    /**
     * 打印链表
     * */
    private void printLink(){
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i].getData());
        }
    }


    /**
     * 打印约瑟夫出队顺序
     * */
    public static void printOlder(){
        LinkedNode head = arr[0];   //当前节点
        LinkedNode temp = arr[n-1];     //当前节点的上一个节点
        LinkedNode delete = null;   //删除的节点
        int i = 0;                  //控制变量


        while(head._next != head){

            i++;

            if (i == m){
                i = 0;
                delete = head;
                head = head._next;
                temp._next = head;
                delete._next = null;
                System.out.println(delete.getData());
            }
            else {
                temp = head;
                head = head._next;
            }
        }
        System.out.println(head.getData());
    }
}
