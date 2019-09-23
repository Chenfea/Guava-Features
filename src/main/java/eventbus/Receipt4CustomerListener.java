package eventbus;

import com.google.common.eventbus.Subscribe;

/****
 *   Created by Feng Chen on 9/15/2019
 */
public class Receipt4CustomerListener {

    @Subscribe
    public void sub(String message){
        System.out.println(message+"\n"+"please send receipt to customer");
    }
}
