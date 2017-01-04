import java.util.concurrent.Flow.*;

public class SubscriberComponent2 implements Subscriber<String> {

    private Subscription subscription;
    
    @Override
    public void onSubscribe(Subscription subscription) {
        System.out.println("Subscribed!");
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(String item) {
        System.out.println("SC2, got next: " + item);
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
