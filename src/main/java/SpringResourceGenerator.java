import commands.DeleteCommand;
import commands.GenerateCommand;
import configuration.help.AdditionalHelpInformation;
import configuration.startup.ANSIStyling;
import configuration.startup.AnsiConsoleManagement;
import picocli.CommandLine;
import utils.CLIConfigurationConstants;

import java.util.logging.Level;
import java.util.logging.Logger;

@CommandLine.Command(name = CLIConfigurationConstants.SPRING_GENERATOR_COMMAND_NAME, subcommands = {DeleteCommand.class, GenerateCommand.class},
        version = CLIConfigurationConstants.VERSION,

        description = CLIConfigurationConstants.SPRING_GENERATOR_COMMAND_DESCRIPTION,
        headerHeading = CLIConfigurationConstants.HEADER_HEADING,
        synopsisHeading = CLIConfigurationConstants.SYNOPSIS_HEADING,
        descriptionHeading = CLIConfigurationConstants.DESCRIPTION_HEADING,
        parameterListHeading = CLIConfigurationConstants.PARAM_LIST_HEADING,
        optionListHeading = CLIConfigurationConstants.OPTION_LIST_HEADING,
        header = CLIConfigurationConstants.SPRING_GENERATOR_COMMAND_HEADER,
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
