package disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import java.nio.ByteBuffer;

public class EventProducer {
    private RingBuffer<Event> ringBuffer;

    public void onData(ByteBuffer byteBuffer) {
        long seq = ringBuffer.next();
        try {
            Event event = ringBuffer.get(seq);
            event.setEvent(byteBuffer);
        } finally {
            ringBuffer.publish(seq);
        }
    }

    public RingBuffer<Event> getRingBuffer() {
        return ringBuffer;
    }

    public void setRingBuffer(RingBuffer<Event> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }
}
