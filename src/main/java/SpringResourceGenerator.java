import commands.DeleteCommand;
import commands.GenerateCommand;
import picocli.CommandLine;
@CommandLine.Command(name = "spring-generator",subcommands = {DeleteCommand.class,GenerateCommand.class},
        version = "1.0.0",
        description = "A Command Line Which Helps Spring Developers To Manage Schematic Easily.",
        headerHeading = "Usage:%n%n",
        synopsisHeading = "%n",
        descriptionHeading = "%nDescription:%n%n",
        parameterListHeading = "%nParameters:%n",
        optionListHeading = "%nOptions:%n",
        header = "A CLI Tool For Spring Applications.",
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
