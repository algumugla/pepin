package hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.boot.SpringApplication;
import org.springframework.test.context.junit4.SpringRunner;

import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(SpringRunner.class)
@PrepareForTest(SpringApplication.class)
public class ApplicationTest {

    @Test
    public void applicationRun() {
        mockStatic(SpringApplication.class);
        String[] args = {"toto", "tutu"};

        Application.main(args);

        verifyStatic(SpringApplication.class);
        SpringApplication.run(Application.class, args);
    }

}
