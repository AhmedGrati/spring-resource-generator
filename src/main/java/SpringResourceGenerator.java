import commands.DeleteCommand;
import commands.GenerateCommand;
import configuration.help.AdditionalHelpInformation;
import configuration.startup.ANSIStyling;
import configuration.startup.AnsiConsoleManagement;
import picocli.CommandLine;
import utils.Constants;

import java.util.logging.Level;
import java.util.logging.Logger;

@CommandLine.Command(name = Constants.SPRING_GENERATOR_COMMAND_NAME, subcommands = {DeleteCommand.class, GenerateCommand.class},
        version = Constants.VERSION,

        description = Constants.SPRING_GENERATOR_COMMAND_DESCRIPTION,
        headerHeading = Constants.HEADER_HEADING,
        synopsisHeading = Constants.SYNOPSIS_HEADING,
        descriptionHeading = Constants.DESCRIPTION_HEADING,
        parameterListHeading = Constants.PARAM_LIST_HEADING,
        optionListHeading = Constants.OPTION_LIST_HEADING,
        header = Constants.SPRING_GENERATOR_COMMAND_HEADER,
        mixinStandardHelpOptions = true)
public class SpringResourceGenerator implements Runnable {

    public final Logger logger = Logger.getLogger(SpringResourceGenerator.class.getName());

    /**
     * @param args
     */
    public static void main(String[] args) {
        // Declaring our command line which will pass through a pipeline to change some fields in it.
        CommandLine commandLine = new CommandLine(new SpringResourceGenerator());

        // Add the "available schematics" section
        commandLine = AdditionalHelpInformation.addAnotherHelpSection(commandLine);

        // Configuring the ANSI Coloring ans Styling
        CommandLine.Help.ColorScheme colorScheme = ANSIStyling.configureANSIStyling();

        // Change the color schema of the command with the generated one.
        commandLine.setColorScheme(colorScheme);

        // Enable coloring in windows systems.
        AnsiConsoleManagement.install();

        // execute the command line.
        int exitCode = commandLine.execute(args);

        System.exit(exitCode);

        AnsiConsoleManagement.uninstall();
    }

    @Override
    public void run() {

        logger.log(Level.INFO, "RUN METHOD");

    }
}
