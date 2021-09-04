/**
 * @author zjw
 * @package DataStructure
 * @Date 2021/9/4
 * @Time 16:43
 */
public class test {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        queue.addQueue(1);
        queue.addQueue(2);
        queue.addQueue(3);
        queue.addQueue(4);
        queue.addQueue(5);

        System.out.println("--------------------------");
        System.out.println(queue.getQueue());
        System.out.println(queue.getQueue());

        System.out.println("--------------------------");
        queue.showQueue();
    }
}
