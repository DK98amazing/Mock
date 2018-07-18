package disruptor;

import com.lmax.disruptor.EventHandler;

public class EventFactory implements EventHandler<Event>{
    public void onEvent(Event o, long l, boolean b) throws Exception {
            System.out.println("Event Data: " + o.getEvent().getLong(0));
    }
}
