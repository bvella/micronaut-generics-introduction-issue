package issue;

import io.micronaut.test.annotation.MicronautTest;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;

@MicronautTest
public class IssueTest {
    
    @Inject public SpecificPublisher publisher;
    
    @Test
    public void test() {
        publisher.publish(new SpecificEvent());
    }
    
}
