package algorithms;

import java.util.*;

public class Anagrams {

    Map<String,List<String>> looupList =  new HashMap<>();

    public void findAnagrams(List<String> words) {



        for(String word: words){
            String signature = findSignature(word);
            if (looupList.containsKey(signature)) {
                looupList.get(signature).add(word);
            } else {
                ArrayList<String> anagramList = new ArrayList<>();
                anagramList.add(word);
                looupList.put(signature,anagramList);
            }
        }
    }

    private String findSignature(String word) {
        byte[] bytes = word.getBytes();
        Arrays.sort(bytes);
        return new String(bytes);
    }

    public List<String> getAnagrams(String word) {
        String signature = findSignature(word);
        List<String> anagrams = looupList.get(signature);
        return anagrams == null ? new ArrayList<>() : anagrams;
    }
}
