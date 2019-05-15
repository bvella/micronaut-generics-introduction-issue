package issue;

import javax.inject.Singleton;

@Singleton
public class Issue {

    private final SpecificPublisher publisher;

    public Issue(final SpecificPublisher publisher) {
        this.publisher = publisher;
    }

    public void publish() {
        publisher.publish(new SpecificEvent());
    }

}
