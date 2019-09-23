package collections;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.primitives.Ints;

/****
 *   Created by Feng Chen on 9/18/2019
 */
public class GuavaMultimapTest {

    public static void main(String[] arg){
        Multimap<String,Integer> multimap = ArrayListMultimap.create();
        multimap.put("a",1);
        multimap.put("a",7);
        multimap.putAll("a", Ints.asList(2,3,4));
        multimap.putAll("b", Ints.asList(5,6,7));
        multimap.putAll("c", Ints.asList(8,9));

        System.out.println("value of key a: "+ multimap.get("a"));
        System.out.println("value of key b: "+ multimap.get("b"));
        System.out.println("value of key c: "+ multimap.get("c"));
        multimap.remove("b",5);
        System.out.println("After remove, value of key b: "+ multimap.get("b"));
        multimap.removeAll("c");
        System.out.println("After removeAll, value of key c: "+ multimap.get("c"));
    }
}
