package eventbus;

import com.google.common.eventbus.Subscribe;

import javax.sound.midi.SysexMessage;

/****
 *   Created by Feng Chen on 9/14/2019
 */
public class Customer1Listener {

    @Subscribe
    public void observe(String message){
        System.out.println("Get message from Customer1: "+message);
    }
}
