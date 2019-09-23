package collections;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/****
 *   Created by Feng Chen on 9/16/2019
 */
public class GuavaMultisetTest {

    public static void main(String[] arg) throws FileNotFoundException {
//        GuavaMultisetTest.countWords();
        GuavaMultisetTest.testMultiset();
    }

    public static void countWords() throws FileNotFoundException {
        Map<String, Integer> counts = new HashMap<String, Integer>();
        List<String> wordList = getWordList();
        for (String s : wordList) {
            Integer count = counts.get(s);
            if (count == null) {
                counts.put(s, 1);
            } else {
                counts.put(s, count + 1);
            }
        }
        //System.out.println(counts.toString());
        String word = "dream";
        System.out.println("time of word('"+word+"'): "+ counts.get(word));
    }

    public static void testMultiset() throws FileNotFoundException {
        Multiset<String> multiset = HashMultiset.create();
        multiset.addAll(getWordList());

        System.out.println("time of word('dream'): "+ multiset.count("dream"));
        System.out.println("distinct words count: "+ multiset.elementSet().size());
        for(Multiset.Entry e : multiset.entrySet() ){
            if(e.getElement().equals("dream"))
                System.out.println(e.getElement() + ":" + e.getCount());
        }
//        multiset.setCount("dream", 9);
//        System.out.println("time of word('dream'): "+ multiset.count("dream"));
    }

    private static List<String> getWordList() throws FileNotFoundException {
        List list = new ArrayList<String>();
        File file=new File("doc/dream.txt");
        if(!file.exists())
            System.out.println("no such file");
        Scanner scanner=new Scanner(file);
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] lineWords = line.split("\\W+");
            for(String word : lineWords){
                list.add(word);
            }
        }
        //System.out.println("words count: "+ list.size());
        return list;
    }
}
