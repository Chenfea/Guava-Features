package cache;

import com.google.common.cache.*;
import model.Customer;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/****
 *   Created by Feng Chen on 9/14/2019
 */
public class GuavaCacheTest1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException{
        LoadingCache<Integer, Customer> CustomerCache = CacheBuilder.newBuilder() //To get a Cache builder instance using its static method .newBuilder()
                .expireAfterWrite(8, TimeUnit.SECONDS)//expire in 8 seconds after cache is written
                .initialCapacity(1)
                .maximumSize(2) //max size is 2, and some elements would be evicted according to LRU(least-recently-used) algorithm.
                .recordStats() // set this to record statistic of cache used.
                .removalListener(new RemovalListener<Object, Object>() { // set to inform when object in cache is evicted.
                    @Override
                    public void onRemoval(RemovalNotification<Object, Object> notification) {
                        System.out.println(notification.getKey() + " was removed, reason is " + notification.getCause());
                    }
                })
                .recordStats()
                .build(
                        new CacheLoader<Integer, Customer>() { // when not found in cache, auto-load it using CacheLoader
                            @Override
                            public Customer load(Integer id) throws Exception {
                                System.out.println("load Customer " + id);
                                Customer Customer = new Customer();
                                Customer.setId(id);
                                Customer.setName("name " + id);
                                return Customer;
                            }
                        }
                );

        for (int i=0;i<20;i++) {
            Customer Customer = CustomerCache.getUnchecked(1);
            //Customer Customer = CustomerCache.get(1);// get data from cache, if no found in cache, load it using CacheLoader.
            System.out.print("i="+i+"  ");
            System.out.println( Customer);
            if(i==10) {
                Customer Customer2 = CustomerCache.get(2);
                Customer Customer3 = CustomerCache.get(3);
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println("cache stats:");
        System.out.println(CustomerCache.stats().toString());
    }
}
