package hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.BDDMockito.given;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.core.Is.is;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@RunWith(SpringRunner.class)
@WebMvcTest(GreetingController.class)
public class GreetingControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private GreetingController greetingController;

    @Test
    public void getGreeting() throws Exception {
        Greeting greeting = new Greeting(1, "toto");

        given(greetingController.greeting("toto")).willReturn(greeting);

        mvc.perform(get("/greeting?name=toto"))
                .andExpect(jsonPath("$['id']", is(new Integer(String.valueOf(greeting.getId())))))
                .andExpect(jsonPath("$['content']", is(greeting.getContent())));
    }

    @Test
    public void testGreeting() {
        GreetingController greetingController = new GreetingController();

        Greeting greeting1 = greetingController.greeting("toto");


        assertThat(greeting1.getId()).isEqualTo(1);
        assertThat(greeting1.getContent()).isEqualTo("toto");

        Greeting greeting2 = greetingController.greeting("tutu");

        assertThat(greeting2.getId()).isEqualTo(2);
        assertThat(greeting2.getContent()).isEqualTo("tutu");
    }




}
