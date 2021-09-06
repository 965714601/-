/**
 * @author zjw
 * @package DataStructure
 * @Date 2021/9/6
 * @Time 11:52
 */
public class Test {
    public static void main(String[] args) {

        LinkedNode<String> Four = new LinkedNode<>(null, "Four");
        LinkedNode<String> Third = new LinkedNode<>(Four, "Third");
        LinkedNode<String> Second = new LinkedNode<>(Third, "Second");
        LinkedNode<String> First = new LinkedNode<>(Second, "First");


        LinkedNode head = LinkedNode.init();
        head.add(First);
        head.printLinkedNode();

        System.out.println("-------------------------------------------------");

        head.add(new LinkedNode(null,"Five"));
        head.printLinkedNode();

        System.out.println("-------------------------------------------------");
       head.findByData("Second");

        System.out.println("-------------------------------------------------");
        head.modifyNode("第一","First");
        head.printLinkedNode();



        System.out.println("-------------------------------------------------");

        head.deleteByData("Five");
        head.printLinkedNode();

        System.out.println("-------------------------------------------------");
        System.out.println("链表的有效个数： " + head.getLinkedLength());

        System.out.println("-------------------------------------------------");
        System.out.println("倒数第二个的节点：" + head.findByNumber(2).getData());

        System.out.println("反转前，后续遍历链表: ");
        head.printReverseLinked();

        System.out.println("-------------------------------------------------");
        head.reverseLinked();
        head.printLinkedNode();

        System.out.println("-------------------------------------------------");
        System.out.println("反转后，后续遍历链表: ");
        head.printReverseLinked();
    }

}
