package disruptor;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Main {
    private static Disruptor<Event> disruptor;
    private static int bufferSize = 1024 * 1024;
    private static com.lmax.disruptor.EventFactory eventFactory = new EventFac();
    static {
        disruptor = new Disruptor<Event>(eventFactory, bufferSize, Executors.defaultThreadFactory(), ProducerType.SINGLE, new BlockingWaitStrategy());
        disruptor.handleEventsWith(new EventFactory());
        try {
            disruptor.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String args[]) {
        RingBuffer<Event> ringBuffer = disruptor.getRingBuffer();
        EventProducer producer = new EventProducer();
        producer.setRingBuffer(ringBuffer);
        ByteBuffer bb = ByteBuffer.allocate(8);
        for (long l = 0; true; l++)
        {
            bb.putLong(0, l);
            bb.putLong(0,l+1);
            bb.putLong(0,l+2);
            bb.putLong(0,l+3);

            //生产者向RingBuffer中写入消息
            producer.onData(bb);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
