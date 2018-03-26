package retries;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class MapJava {

    @Test
    public void testHashMap() {
        HashMap<String, Integer> hashMap = new HashMap<>();

        System.out.println(hashMap);
        System.out.println(hashMap.size());
    }

    @Test
    public void testLinkedHashMap(){
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1,10);
        linkedHashMap.put(2,11);
        linkedHashMap.put(3,13);
        linkedHashMap.put(0,9);

//        System.out.println(linkedHashMap);
//        System.out.println(linkedHashMap.keySet());
//        System.out.println(linkedHashMap.values());
//        System.out.println(linkedHashMap.size());

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Iterator<Integer> iterator = linkedHashMap.keySet().iterator();

                while (iterator.hasNext())
                    System.out.println(iterator.next());
            }
        });
        thread.start();

        while(thread.isAlive()) {
            linkedHashMap.keySet().forEach(
                    x -> linkedHashMap.put(Integer.valueOf(x), 999)
            );
        }

        System.out.println(linkedHashMap);

    }

    @Test
    public void testConcurrentHashMap() throws InterruptedException {
        boolean canRunn = false;

        ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(1,100);
        concurrentHashMap.put(2,200);
        concurrentHashMap.put(3,300);
        concurrentHashMap.put(4,400);
        concurrentHashMap.put(5,500);
        concurrentHashMap.put(6,600);
        concurrentHashMap.put(7,700);
        concurrentHashMap.put(8,800);
        concurrentHashMap.put(9,900);


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                concurrentHashMap.keySet().forEach(
                    x -> concurrentHashMap.put(Integer.valueOf(x), 555)
            );
            }
        });
        thread.start();



        while(thread.isAlive()) {
            concurrentHashMap.keySet().forEach(
                    x -> concurrentHashMap.put(Integer.valueOf(x), 999)
            );
        }

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                concurrentHashMap.keySet().forEach(
                        x -> { if(x % 2 == 0 )
                            concurrentHashMap.put(Integer.valueOf(x), 111);
                        }
                );
            }
        });
        thread2.start();

        while(thread2.isAlive()){
            System.out.println(concurrentHashMap);
        }

        System.out.println();
        System.out.println(concurrentHashMap);

    }

    @Test
    public void testHashMapForConcurrency() throws InterruptedException {
        boolean canRunn = false;

        ConcurrentHashMap<Integer, Integer> hashmap = new ConcurrentHashMap<>();
        hashmap.put(1,100);
        hashmap.put(2,200);
        hashmap.put(3,300);
        hashmap.put(4,400);
        hashmap.put(5,500);
        hashmap.put(6,600);
        hashmap.put(7,700);
        hashmap.put(8,800);
        hashmap.put(9,900);


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                hashmap.keySet().forEach(
                        x -> hashmap.put(Integer.valueOf(x), 555));
                System.out.print(hashmap);
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                hashmap.keySet().forEach(
                        x -> { if(x % 2 == 0 )
                            hashmap.put(Integer.valueOf(x), 111);
                        }
                );
            }
        });


        thread.start();

        thread2.start();


        while(thread.isAlive() || thread2.isAlive()) {
            hashmap.put(new Random().nextInt(), 333);
            System.out.println(hashmap);
        }


        System.out.println();
        System.out.print(" -----> ");
        System.out.print(hashmap);
        System.out.println();

    }
}
