package disruptor;

import java.nio.ByteBuffer;

public class Event {
    private ByteBuffer event;

    public ByteBuffer getEvent() {
        return event;
    }

    public void setEvent(ByteBuffer event) {
        this.event = event;
    }
}
