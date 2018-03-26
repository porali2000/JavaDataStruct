package retries;

import org.junit.Test;

import javax.management.AttributeList;
import javax.management.relation.Role;
import java.util.*;

public class CoreJava {

    @Test
    public void testVector() {
        Vector<Long> vector = new Vector<>();
        vector.add(0L);
        vector.add(1L);
        for (int i = 2; vector.size() < 50; i++) {
            vector.add(vector.lastElement() + vector.get(i - 2));
        }
        Iterator<Long> iterator = vector.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    @Test
    public void testStack() {
        Stack<Integer> stack = new Stack<>();

        stack.add(1);
        System.out.println(stack.peek());
        stack.push(3);
        stack.add(3);
        int cnt = 0;
        while (stack.pop() != 1) {
            System.out.println("count = " + ++cnt);
        }


        System.out.println(stack);
        System.out.println(stack.size());
        System.out.println(stack.capacity());
    }

    @Test
    public void testDeque() {
        Deque<Integer> deque = new ArrayDeque<>();

        deque.offer(2);
        deque.addLast(3);
        deque.addFirst(1);
        deque.add(1);
        deque.add(1);
        System.out.println(deque);


        System.out.println(deque);
        System.out.println(deque.size());
    }

    @Test
    public void testTreeSet() {
        Set treeSet = new TreeSet();
        treeSet.add(34);
        treeSet.add(34);
        treeSet.add(4);
        treeSet.add(4);
        System.out.println(treeSet);
    }

    @Test
    public void testSet() {
        Set treeSet = new HashSet();
        treeSet.add(34);
        treeSet.add(34);
        treeSet.add(4);
        treeSet.add(4);
        System.out.println(treeSet);
    }

    @Test
    public void testArrayList() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.ensureCapacity(10);
        arrayList.add(1);
        arrayList.add(null);
        arrayList.add(3);
        arrayList.add(999999999);

        System.out.println(arrayList);
        System.out.println(arrayList.size());
        Collection<Integer> integers = Collections.synchronizedCollection(arrayList);
    }

    @Test
    public void testAttributeList() {
        AttributeList attributeList = new AttributeList();
        attributeList.add(1);
        attributeList.add(1L);
        attributeList.add(new ArrayList<>());
        System.out.println(attributeList);
        System.out.println(attributeList.size());
    }

    @Test
    public void testLinkedList() {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(4);
        linkedList.add(3);
        linkedList.add(1);
        linkedList.add(2);

        System.out.println(linkedList);
        System.out.println(linkedList.size());
    }

    @Test
    public void testRoleList() {
        Role role = new Role("Admin", new ArrayList<>());
        System.out.println(role);

    }

    @Test
    public void testListIterator() {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(3);
        vector.add(5);
        System.out.println(vector);
        ListIterator<Integer> integerListIterator = vector.listIterator();
        while (integerListIterator.hasNext()) {
            System.out.println(integerListIterator.next());
        }
    }

    @Test
    public void testHashAndEqual() {
        String s1 = new String("100");
        String s2 = new String("100");
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s1.equals(s2));
        System.out.println(s2.equals(s1));
        System.out.println(s1 == s2);
        System.out.println(s2 == s1);
    }

    @Test
    public void testShortest() {
        String s1 = "0139";
        char input = '6';

        char result = ' ';
        char previous = ' ';
        for (char x : s1.toCharArray()) {
            if (Math.abs(input - x) == 0) {
                result = x;
                break;
            }

            if (Math.abs(input - x) < Math.abs(input - previous) ) {
                result = x;
                previous = x;
            }
        }
        System.out.println(s1);
        System.out.println();
        System.out.println(input);
        System.out.println();
        System.out.println(result);

    }

    @Test
    public void testNMultiplication(){
        int n = 10;
        int i = 1;
        while( i <= n){
            System.out.print("    "+i + "    ");
            System.out.print(i*=10);
            System.out.println("    "+i);
        }
    }
}

