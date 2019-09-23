package eventbus;

import com.google.common.eventbus.EventBus;

/****
 *   Created by Feng Chen on 9/14/2019
 */
public class GuavaEventBus {

    private static EventBus eventBus = new EventBus();

    public static void main(String[] args) {
        Customer1Listener listener1 = new Customer1Listener();
        eventBus.register(listener1);
        Customer2Listener listener2 = new Customer2Listener();
        eventBus.register(listener2);

        System.out.println("============   start  ====================");
        eventBus.post("Hello, I am customer1"); // this is for Customer1Listener
        eventBus.post(20121212);// this is for Customer2Listener
        eventBus.post(20111111);

        System.out.println("============   remove customer2 listener  ====================");
        eventBus.unregister(listener2);
        eventBus.post("Again, I am customer1"); // this is for Customer1Listener
        eventBus.post(20150505);// this is for Customer2Listener

        System.out.println("============   re-add customer2 listener  ====================");
        eventBus.register(listener2);
        eventBus.post("Again and again, I am customer1"); // this is for Customer1Listener
        eventBus.post(20160606);// this is for Customer2Listener
    }
}
