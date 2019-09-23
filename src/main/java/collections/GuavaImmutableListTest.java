package collections;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GuavaImmutableListTest {
    private static List<String> getList() {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        return list;
    }

    //This is test for java's Collections.unmodifiedList
    public void testUnmodifiedList(){
        List<String> list = getList();
        //List<String> list = Arrays.asList("a","b","c");
        List<String> unmodifiedList = Collections.unmodifiableList(list);
        unmodifiedList.add("x");
        System.out.println(list);
        System.out.println(unmodifiedList);

        list.add("d");
        System.out.println("previous list, After add d: "+ list);
        System.out.println("unmodifiedList, After add d in list: "+ unmodifiedList);
    }

    //This is test for Guava's ImmutableList
    public void testGuavaImmutable(){
        List<String> list = getList();
        //Guava immutableList
        ImmutableList<String> imList = ImmutableList.copyOf(list);
        System.out.println("imList: "+imList);
        list.add("e");
        imList.add("r");
        System.out.println("list After add e: "+ list);
        System.out.println("imList After add e: "+ imList);


    }

    public static void main(String[] arg){
        GuavaImmutableListTest gtest = new GuavaImmutableListTest();
//        gtest.testUnmodifiedList();
        gtest.testGuavaImmutable();
    }
}
