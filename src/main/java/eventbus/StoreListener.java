package eventbus;

import com.google.common.eventbus.Subscribe;

import java.util.List;

/****
 *   Created by Feng Chen on 9/15/2019
 */
public class StoreListener {

    @Subscribe
    public void sub(String message){
        System.out.println(message+"\n"+"please update the quantity in store");
    }
}
