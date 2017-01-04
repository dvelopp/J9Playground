import java.util.concurrent.Flow.*;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.*;

public class IntegerTransformProcessor<T,R> extends SubmissionPublisher<R> implements Processor<T,R> {

    private Function function;
    private Subscription subscription;

    public IntegerTransformProcessor(Function<? super T, ? extends R> function) {
        super();
        this.function = function;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        System.out.println("Integer transform processor subscribed!");
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(T item) {
        submit((R) function.apply(item));
        subscription.request(1);
    }

    @Override
    public void onError(Throwable t) {
        System.err.println("Couldn't parse some values");
        //t.printStackTrace();
    }

    @Override
    public void onComplete() {
        close();
    }


}
