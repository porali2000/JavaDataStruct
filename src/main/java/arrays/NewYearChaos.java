package arrays;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class NewYearChaos {
    static Set<Person> newYearLine = new HashSet<>();
    static int n = 5;
    static int[] array = {2, 1, 5, 3, 4};
    static int [] bribeDetails = new int[n];

    public static void main(String[] args) {

        print(array);
        bribe(array, 2, 4);
        bribe(array, 2, 4);
        bribe(array, 2, 4);
        print(array);
        print(bribeDetails);
    }

    static void bribe(int[] array, int from, int to) {
        int p1 = 0;
        while (p1 < array.length && from < array.length && to < array.length) {
            if (p1 == from && bribeDetails[from] < 2) {
                int t1 = array[to];
                array[to] = array[from];
                array[from] = t1;
                bribeDetails[from] ++;
            }
            p1++;
        }
    }

    static void print(int[] array) {
        int p1 = 0;
        while (p1 < array.length) {
            System.out.print(" " + array[p1]);
            p1++;
        }
        System.out.println();
    }

    static void way1() {
        int lineCount = 1;
        while (lineCount < 10) {
            Person person = new Person(lineCount);
            newYearLine.add(person);
            if (lineCount == 4) bribe(person, 3);
            lineCount++;
        }
        System.out.println(newYearLine);
        System.out.println(newYearLine);
    }

    static class Person {
        public int hisPosition;
        public int bribePosition;

        public Person(int hisPosition) {
            this.hisPosition = hisPosition;
            this.bribePosition = hisPosition;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return bribePosition == person.bribePosition;
        }

        @Override
        public int hashCode() {
            return Objects.hash(bribePosition);
        }

        @Override
        public String toString() {
            return "P:" + hisPosition +
                    " [A:" + bribePosition +
                    ']';
        }
    }

    static void bribe(Person person, int position) {
        Optional<Person> personToBribe = newYearLine.parallelStream().filter(x -> x.bribePosition == position).findAny();
        int swap = personToBribe.get().bribePosition;
        personToBribe.get().bribePosition = person.bribePosition;
        person.bribePosition = swap;
    }
}
