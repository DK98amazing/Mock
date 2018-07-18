package disruptor;

import com.lmax.disruptor.EventFactory;

public class EventFac implements EventFactory<Event> {
    public Event newInstance() {
        return new Event();
    }
}
