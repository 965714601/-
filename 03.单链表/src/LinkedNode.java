/**
 * @author zjw
 * @package DataStructure
 * @Date 2021/9/6
 * @Time 11:10
 */
public class LinkedNode<T> {
    private  static  LinkedNode head = new LinkedNode(null,null);
    private LinkedNode next;
    private T data;



    public LinkedNode(LinkedNode linkedNode, T data){
        this.next = linkedNode;
        this.data = data;
    }

    /**
     * 链表头结点初始化
     * */
    public static LinkedNode init(){
        return head;
    }

    public static void headAddNext(LinkedNode linkedNode){
        head.next = linkedNode;
    }



    public LinkedNode(T data) {
        this.data = data;
        this.next = null;
    }

    /**
     * 添加数据到链表
     * */
    public void add(LinkedNode linkedNode){
        LinkedNode head = LinkedNode.head;
        while(head.next != null){
            head = head.next;
        }
        head.next = linkedNode;
    }

    /**
    * 查找链表中的数据
    * */
    public LinkedNode findByData(T data){
        LinkedNode linkedNode = head.next;

        while(linkedNode.next != null){
            if (linkedNode.data == data) {
                System.out.println("找到了" + data + "数据对应的节点");
                return linkedNode;
            }
            else linkedNode = linkedNode.next;
        }

        return null;
    }


    /**
    *  修改链表数据
    * */

    public boolean modifyNode(T newData,T oldData){

        LinkedNode linkedNode = head.next;

        while (linkedNode.next !=null){

            if (linkedNode.data == oldData) {
                linkedNode.data = newData;
                System.out.println("找到了" + oldData + "值的节点,并改为新值:" + newData);
                return true;
            }
            else linkedNode = linkedNode.next;
        }
        return false;
    }

    /**
     * 删除节点
     * */

    public boolean deleteByData(T data){

        LinkedNode pre = head;

        LinkedNode next = head.next;

        while(pre.next != null){
            if (pre.next.data == data){
                System.out.println("删除的节点数据：" + pre.next.data);
                pre.next = next.next;

                return true;
            }

            pre = pre.next;
            next = next.next;
        }

        return false;
    }


    /**
     * 打印链表
     * */

    public void printLinkedNode(){
        System.out.println("打印链表开始---------------");
        LinkedNode linkedNode = this;
        while(linkedNode.next != null) {
            System.out.println(linkedNode.next.data);
            linkedNode = linkedNode.next;
        }
        System.out.println("打印链表结束----------------");
    }



}
