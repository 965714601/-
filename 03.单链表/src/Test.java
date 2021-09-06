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

//        LinkedNode head = new LinkedNode<String>(First,null);
        LinkedNode head = LinkedNode.init();
        head.add(First);
        head.printLinkedNode();

        System.out.println("-------------------------------------------------");

        head.add(new LinkedNode("Five"));
        head.printLinkedNode();

        System.out.println("-------------------------------------------------");
        System.out.println(head.findByData("Second"));

        System.out.println("-------------------------------------------------");
        head.modifyNode("第一","First");
        head.printLinkedNode();

        System.out.println("-------------------------------------------------");
        boolean b = head.deleteByData("Third");
        head.printLinkedNode();
    }
}
