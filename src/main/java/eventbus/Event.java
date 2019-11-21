package eventbus;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import org.junit.Test;
//import org.junit.jupiter.api.Test;

/****
 *   Created by Feng Chen on 9/14/2019
 */
public class Event {

    @Subscribe
    public void sub(String messsage){
        System.out.println(messsage);
    }

    @Test
    public void testEventBus() {
        EventBus eventBus = new EventBus();
        System.out.println("this is a test");
        eventBus.register(new Event());
        eventBus.post("hello, this is new message!yeah");
    }

}
