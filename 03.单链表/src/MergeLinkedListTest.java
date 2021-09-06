/**
 * @author zjw
 * @package DataStructure
 * @Date 2021/9/6
 * @Time 19:59
 */
public class MergeLinkedListTest {
    public static void main(String[] args) {
        LinkedNode<Integer> Four = new LinkedNode<>(null, 8);
        LinkedNode<Integer> Third = new LinkedNode<>(Four, 5);
        LinkedNode<Integer> Second = new LinkedNode<>(Third, 2);
        LinkedNode<Integer> First = new LinkedNode<>(Second, 1);
        LinkedNode<Integer> head1 = new LinkedNode<>(First, null);


        LinkedNode<Integer> four = new LinkedNode<>(null, 9);
        LinkedNode<Integer> third = new LinkedNode<>(four, 6);
        LinkedNode<Integer> second = new LinkedNode<>(third, 4);
        LinkedNode<Integer> first = new LinkedNode<>(second, 3);
        LinkedNode<Integer> head2 = new LinkedNode<>(first, null);


        head1.printLinkedNode();
        head2.printLinkedNode();

        LinkedNode linkedNode = head1.combineLinked(head1, head2);
        linkedNode.printLinkedNode();
    }
}
