package disruptor;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import java.nio.ByteBuffer;

public class EventProducer {
    private RingBuffer<Event> ringBuffer;

    //disruptor 3.0
    public void onData(ByteBuffer byteBuffer) {
//        long seq = ringBuffer.next();
//        Event event = null;
        try {
//            event = ringBuffer.get(seq);
//            event.setEvent(byteBuffer);
        } finally {
            ringBuffer.publishEvent(new EventTranslatorOneArg<Event, ByteBuffer>() {
                public void translateTo(Event event, long l, ByteBuffer byteBuffer) {
                    event.setEvent(byteBuffer);
                }
            }, byteBuffer);
//            ringBuffer.publish(seq);
        }
    }

    public RingBuffer<Event> getRingBuffer() {
        return ringBuffer;
    }

    public void setRingBuffer(RingBuffer<Event> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }
}
