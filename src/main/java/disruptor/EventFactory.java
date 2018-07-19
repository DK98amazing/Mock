package disruptor;

import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.lmax.disruptor.EventHandler;

import javax.annotation.Nullable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class EventFactory implements EventHandler<Event>{
    public void onEvent(Event o, long l, boolean b) throws Exception {
        final SettableFuture<Integer> settableFuture = SettableFuture.create();
        settableFuture.set(5);
        Future future = Futures.lazyTransform(settableFuture, new Function<Integer, Integer>() {
            @Nullable
            public Integer apply(@Nullable Integer integer) {
                try {
                    return settableFuture.get() + 1;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                return null;
            }
        });
        System.out.println("Event Data: " + future.get() + o.getEvent().getLong(0));
    }
}
