package kafkapush;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class OptionsTest {
    String args1 = "-b myhost:1234";
    String args2 = "-bbighost:1234";
    String args3 = "-b myhost :1234";
    String args4 = "-b :2345";

    @Test
    void topicOptionTest(){
        assertEquals("myhost:1234", new CliOpts(args1).getBootstrap());
        assertEquals("bighost:1234", new CliOpts(args2).getBootstrap());
        assertEquals("localhost:2345", new CliOpts(args4).getBootstrap());
    }
}