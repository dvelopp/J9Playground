import java.util.concurrent.Flow.*;

public class SubscriberComponent2 implements Subscriber<Integer> {

    private Subscription subscription;
    
    @Override
    public void onSubscribe(Subscription subscription) {
        System.out.println("Subscribed!");
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(Integer item) {
        System.out.println("Item in power two is: " + (item * item));
        subscription.request(1);
    }

    @Override
    public void onError(Throwable t) {
        t.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Done");
    }

}
