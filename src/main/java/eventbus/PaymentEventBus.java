package eventbus;

import com.google.common.eventbus.EventBus;

/****
 *   Created by Feng Chen on 9/15/2019
 */
public class PaymentEventBus {

    private static EventBus eventBus = new EventBus();

    public static void main(String[] args) {
        eventBus.register(new Receipt4CustomerListener());
        eventBus.register(new StoreListener());

        //eventBus.register(new Receipt4CustomerListener());
        eventBus.post("Customer 12345 has bought 5 apples and 10 eggs.");

    }
}
