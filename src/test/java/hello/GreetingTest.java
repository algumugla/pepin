package hello;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GreetingTest {

    @Test
    public void testGreetingConstructor() {
        Greeting greeting = new Greeting(2, "toto");
        assertThat(greeting.getId()).isEqualTo(2);
        assertThat(greeting.getContent()).isEqualTo("toto");
    }

}
