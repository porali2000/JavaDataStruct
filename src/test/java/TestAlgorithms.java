import algorithms.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TestAlgorithms {
    @Test
    public void testFizzBuzz(){
        FizzBuzz xxx = new FizzBuzz();
        List<String> fizz=  xxx.doFizzBuzz(10000);
        System.out.println(fizz);
    }

    @Test
    public void testFibonacci(){
        Fibonacci xx = new Fibonacci();
        List<Integer> dofibonacci = xx.dofibonacci(8);
        System.out.println(dofibonacci);
    }

    @Test
    public void testFibonacciForNth(){
        Fibonacci xx = new Fibonacci();
        Map<Integer,Long> dofibonacci = xx.dofibonacciForNth(100);
        System.out.println(dofibonacci.get(100));
    }

    @Test
    public void testFibonacciForNthRecursively(){
        Fibonacci xx = new Fibonacci();
        System.out.println(xx.fibN(4));
    }

    @Test
    public void testfactorial(){

        System.out.println(Factorial.factorialLinear(2));

    }

    @Test
    public void testAnagrams(){

        List<String> wordList = new ArrayList<>();
        wordList.add("Dormitory");
        wordList.add("keep");
        wordList.add("peek");
        wordList.add("school master");
        wordList.add("the classroom");
        wordList.add("Dirty Room");

        Anagrams anagrams = new Anagrams();
        anagrams.findAnagrams(wordList);

        System.out.println(anagrams.getAnagrams("peek"));

    }

    @Test
    public void testStringReversalLinear(){
        System.out.println(StringReversal.reverseStringLinear("abcdefgh"));
        System.out.println(StringReversal.reverseEfficiently("abcdefgh"));
    }

    @Test
    public void testpalandrome(){
        System.out.println(Palindrome.ispallidrome("eeeel"));
    }
}
