package task_5;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Gap {
    List<String> array = new ArrayList<>();
    List<String> linked = new LinkedList<>();

    public Gap(){
        array.add("aa");
        array.add("bb");
        array.add("cc");
        array.add("dd");
        array.add("ee");

        linked.add("aa");
        linked.add("bb");
        linked.add("cc");
        linked.add("dd");
        linked.add("ee");
    }

    public void timeAdd(String element) throws InterruptedException {
        Instant start = Instant.now();
        array.add(element);
        Thread.sleep(1000);
        Instant finish = Instant.now();
        long elapsed = Duration.between(start, finish).toMillis();
        System.out.println("Time ArrayList add: " + elapsed + " ms");
        Instant startTime1 = Instant.now();
        linked.add(element);
        Thread.sleep(1000);
        long estimatedTime1 = Duration.between(startTime1, Instant.now()).toMillis();
        System.out.println("Time LinkedList add: " + estimatedTime1 + " ms");
        System.out.println("Difference: " + Math.abs(elapsed - estimatedTime1) + " ms");
        if (elapsed > estimatedTime1)
            System.out.println("LinkedList is Faster!");
        else if (elapsed == estimatedTime1) System.out.println("Time is equally");
        else System.out.println("ArrayList is Faster!");
        System.out.println();
    }

    public void timeDelete(String element) throws InterruptedException{
        Instant startTime = Instant.now();
        array.remove(element);
        Thread.sleep(1000);
        long estimatedTime = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("Time ArrayList remove: " + estimatedTime + " ms");
        Instant startTime1 = Instant.now();
        linked.remove(element);
        Thread.sleep(1000);
        long estimatedTime1 = Duration.between(startTime1, Instant.now()).toMillis();
        System.out.println("Time LinkedList remove: " + estimatedTime1 + " ms");
        System.out.println("Difference: " + Math.abs(estimatedTime - estimatedTime1) + " ms");
        if (estimatedTime > estimatedTime1)
            System.out.println("LinkedList is Faster!");
        else if (estimatedTime == estimatedTime1) System.out.println("Time is equally");
        else System.out.println("ArrayList is Faster!");
        System.out.println();
    }

    public void timeFind(String element) throws InterruptedException{
        Instant startTime = Instant.now();
        array.contains(element);
        Thread.sleep(1000);
        long estimatedTime = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("Time ArrayList contain: " + estimatedTime + " ms");
        Instant startTime1 = Instant.now();
        linked.contains(element);
        Thread.sleep(1000);
        long estimatedTime1 = Duration.between(startTime1, Instant.now()).toMillis();
        System.out.println("Time LinkedList contain: " + estimatedTime1 + " ms");
        System.out.println("Difference: " + Math.abs(estimatedTime - estimatedTime1) + " ms");
        if (estimatedTime > estimatedTime1)
            System.out.println("LinkedList is Faster!");
        else if (estimatedTime == estimatedTime1) System.out.println("Time is equally");
        else System.out.println("ArrayList is Faster!");
        System.out.println();
    }

    public void timeInsert(int index, String element) throws InterruptedException{
        Instant startTime = Instant.now();
        array.add(index, element);
        Thread.sleep(1000);
        long estimatedTime = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("Time ArrayList insert: " + estimatedTime + " ms");
        Instant startTime1 = Instant.now();
        linked.add(index, element);
        Thread.sleep(1000);
        long estimatedTime1 = Duration.between(startTime1, Instant.now()).toMillis();
        System.out.println("Time LinkedList insert: " + estimatedTime1 + " ms");
        System.out.println("Difference: " + Math.abs(estimatedTime - estimatedTime1) + " ms");
        if (estimatedTime > estimatedTime1)
            System.out.println("LinkedList is Faster!");
        else if (estimatedTime == estimatedTime1) System.out.println("Time is equally");
        else System.out.println("ArrayList is Faster!");
        System.out.println();
    }

    public static void main(String[] args){
        Gap gap = new Gap();
        try {
            gap.timeAdd("pp");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            gap.timeDelete("cc");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            gap.timeFind("dd");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            gap.timeInsert(2,"ff");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
