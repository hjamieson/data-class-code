package kafkapush;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

public class RegexTest {
    @Test
    void matchMultipleTest(){
        String test1 = "-t topic -b localhost:9092 -h thro -p 1234";
        Pattern p = Pattern.compile("-([tbhp])\s+([a-zA-Z0-9:]+)");
        Matcher m = p.matcher(test1);
        int matches = 0;
        while (m.find()){
            matches++;
        }
        assertEquals(4, matches);
    }

    @Test
    void extractGroupsTest(){
        String test1 = "-t topic -b localhost:9092 -h thro -p 1234";
        Pattern p = Pattern.compile("-([tbhp])\s+([a-zA-Z0-9:]+)");
        Matcher m = p.matcher(test1);
        while (m.find()){
            System.out.printf("%s : %s %n",m.group(1), m.group(2));
        }
    }
    
    @Test
    void missingSpaceTest(){
        String test1 = "-ttopic -blocalhost:9092 -h th0r -p 1234";
        Pattern p = Pattern.compile("-([tbhp])\s*([a-zA-Z0-9:]+)");
        Matcher m = p.matcher(test1);
        int matches = 0;
        while (m.find()){
            matches++;
        }
        assertEquals(4, matches);
    }
}
