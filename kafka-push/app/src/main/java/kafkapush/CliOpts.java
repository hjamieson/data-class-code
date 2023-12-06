package kafkapush;

import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class CliOpts {
    private static Pattern p = Pattern.compile("-([tbhp])\s*([a-zA-Z0-9:]+)");
    private String args;
    private HashMap<String, String> cache = new HashMap<>();

    public CliOpts(String args){
        // use regex to tease out the flags
        Matcher matcher = p.matcher(args);
        while (matcher.find()){
            cache.put(matcher.group(1), matcher.group(2));
        }
    }

    public CliOpts(String[] args){
        this(String.join(" ", Arrays.asList(args)));
    }

    public String getHostName(){
        return (cache.containsKey("h")) ? cache.get("h") : "localhost";
    }

    public String getPort() {
        return (cache.containsKey("p")) ? cache.get("p") : "9092";
    }

    public String getBootstrap(){
        // handle shorthand version
        String bootstrap = null;
        if (cache.containsKey("b")){
            bootstrap = cache.get("b");
            if (bootstrap.startsWith(":")){
                bootstrap = "localhost" + bootstrap;
            } 
        }else {
            bootstrap = String.format("%s:%s",getHostName(), getPort());
        }
        return bootstrap;
    }

    public String getTopic(){
        return (cache.containsKey("t")) ? cache.get("t") : "foo";
    }

}
