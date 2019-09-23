package eventbus;

import com.google.common.eventbus.Subscribe;

import javax.sound.midi.SysexMessage;

/****
 *   Created by Feng Chen on 9/14/2019
 */
public class Customer2Listener {

    @Subscribe
    public void observe(Integer message){
        System.out.println("Get message from Customer2: "+message);
    }
}
