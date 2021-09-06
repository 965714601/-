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


    public LinkedNode(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

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

    public  boolean deleteByData(T data){

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

    public  void printLinkedNode(){
        System.out.println("打印链表开始---------------");
        LinkedNode linkedNode = this;
        while(linkedNode.next != null) {
            System.out.println(linkedNode.next.data);
            linkedNode = linkedNode.next;
        }
        System.out.println("打印链表结束----------------");
    }


    /**
     * 打印链表的有效个数
     * */

    public  int getLinkedLength(){
        int total = 0;
        LinkedNode linkedNode = head;
        while (linkedNode.next != null){
            total++;
            linkedNode = linkedNode.next;
        }

        return total;
    }

    /**
     * 查找倒数第k个节点
     **/

    public  LinkedNode findByNumber(int lastNumber){

        if (lastNumber <= 0 || head.getLinkedLength() < lastNumber || head.next == null)
            return null;

        LinkedNode linkedNode = head.next;
        int length = head.getLinkedLength() - lastNumber;

        while (length != 0){
            length--;
            linkedNode = linkedNode.next;
        }

        return linkedNode;
    }


    /**
     * 链表的反转
     * */

    public  void reverseLinked(){
        LinkedNode newLinkedNode = new LinkedNode<String>(null,null);
        LinkedNode oldLinkedNode = head.next;
        LinkedNode next = null;

        while(oldLinkedNode != null){
          next = oldLinkedNode.next;    //保存旧链表的当前节点的下一个节点
          oldLinkedNode.next = newLinkedNode.next;  //把旧链表的当前节点的下一个节点指向新节点头的下一个节点
          newLinkedNode.next = oldLinkedNode;   //把新链表的下一个节点指向旧链表的当前节点
          oldLinkedNode = next;  //旧链表的当前节点指向下一个节点
        }
        head.next = newLinkedNode.next;
    }

    public  void printReverseLinked(){
        LinkedNode arr[] = new LinkedNode[head.getLinkedLength()];

        LinkedNode linkedNode = head.next;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = linkedNode;
            linkedNode = linkedNode.next;
        }



        for (int i = arr.length - 1; i >= 0 ; i--) {
            System.out.println("第" + (i+1) + "个: " + arr[i].getData());
        }
    }

    /**
     * 合并有序链表
     * */

    public  LinkedNode combineLinked(LinkedNode head1,LinkedNode head2){
        LinkedNode<Integer> head = new LinkedNode<>(null, null);
        if (head1.next == null && head2.next == null)
            return null;

        LinkedNode linkedNode = head;
        head1 = head1.next;
        head2 = head2.next;

        while (head1 != null && head2 != null){

            if ((int)head1.data < (int)head2.data){
                linkedNode.next = head1;
                head1 = head1.next;
            }else {
                linkedNode.next = head2;
                head2 = head2.next;
            }

            linkedNode = linkedNode.next;
        }

        linkedNode.next = head1 == null ? head2 : head1;

        return head;
    }

}
