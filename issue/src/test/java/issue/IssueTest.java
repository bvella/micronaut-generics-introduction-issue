package issue;

import io.micronaut.test.annotation.MicronautTest;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;

@MicronautTest
public class IssueTest {
    
    @Inject public Issue issue;
    
    @Test
    public void test() {
        System.out.println("START");
        issue.publish();
        System.out.println("END");
    }
    
}
