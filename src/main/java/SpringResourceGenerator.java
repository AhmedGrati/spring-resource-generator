import Commands.Command;
import picocli.CommandLine;
@CommandLine.Command(name = "spring-generator",subcommands = {Command.class},
        version = "1.0.0",
        description = "Description for a sample application",
        mixinStandardHelpOptions = true)
public class SpringResourceGenerator implements Runnable{

    public static void main(String[] args) {
        int exitCode = new CommandLine(new SpringResourceGenerator()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public void run() {

    }
}
