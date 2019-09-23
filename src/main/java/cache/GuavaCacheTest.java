package cache;

/****
 *   Created by Feng Chen on 9/11/2019
 */

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class GuavaCacheTest {

    public static void main(String[] arg) throws ExecutionException {
        GuavaCacheTest cacheTest = new GuavaCacheTest();
        cacheTest.loadCache();
        //Lists
    }

    private void loadCache() throws ExecutionException {
        LoadingCache<String, String> cache = CacheBuilder.newBuilder().maximumSize(3)
                .expireAfterAccess(30, TimeUnit.SECONDS)
                .build(
                        new CacheLoader<String, String>() {
                            @Override
                            public String load(String key) throws Exception {
                                System.out.println("load data.");
                                return key + "-test";
                            }
                        }
                );
        String value1 = cache.get("key1");
        System.out.println("value1: "+value1);
        String value2 = cache.get("key2");
        System.out.println("value2: "+value2);

        String value3= cache.getIfPresent("key3");
        System.out.println("value3: "+value3);
    }

}
