// http://gee.cs.oswego.edu/cgi-bin/viewcvs.cgi/jsr166/src/main/java/util/concurrent/SubmissionPublisher.java?view=log
import java.util.concurrent.SubmissionPublisher;
import java.util.List;

public class App {

    public static void main(String ... args) throws Exception {
        // Central component here
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();

        SubscriberComponent1 sub1 = new SubscriberComponent1();
        publisher.subscribe(sub1);

        System.out.println(publisher.hasSubscribers());

        Thread.sleep(5000);
        
        System.out.println("Publishing Items...");  
        List.<String>of("1", "2", "3", "one", "two", "three").stream().forEach(i -> publisher.submit(i));
        
        Thread.sleep(5000);

        publisher.close(); 
    }

}
