/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package kafkapush;

public class App {

    public static void main(String[] args) {
        // read the args:
        CliOpts cli = new CliOpts(args);
        System.out.println(cli.getBootstrap());
        System.out.println(cli.getTopic());
        System.out.println(cli.getHostName());
        System.out.println(cli.getPort());
    }
}
