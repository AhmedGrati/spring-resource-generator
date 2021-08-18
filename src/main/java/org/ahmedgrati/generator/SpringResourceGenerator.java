
package org.ahmedgrati.generator;
import org.ahmedgrati.generator.commands.DeleteCommand;
import org.ahmedgrati.generator.commands.GenerateCommand;
import org.ahmedgrati.generator.configuration.help.AdditionalHelpInformation;
import org.ahmedgrati.generator.configuration.startup.ANSIStyling;
import org.ahmedgrati.generator.configuration.startup.AnsiConsoleManagement;
import org.ahmedgrati.generator.utils.CLIConfigurationConstants;
import org.ahmedgrati.generator.utils.ResourceParameter;
import picocli.CommandLine;

import java.util.logging.Level;
import java.util.logging.Logger;

@CommandLine.Command(name = CLIConfigurationConstants.SPRING_GENERATOR_COMMAND_NAME,
        subcommands = {DeleteCommand.class, GenerateCommand.class},
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

    /**
     * Logger.
     */
    private final Logger logger = Logger.getLogger(SpringResourceGenerator.class.getName());

    /**
     * Getter which returns the class specific logger.
     * @return Logger
     */
    public Logger getLogger() {
        return logger;
    }

    /**
     * @param args
     */
    public static void main(final String[] args) {
        // Declaring our command line which will pass through a pipeline to change some fields in it.
        CommandLine commandLine = new CommandLine(new SpringResourceGenerator());

        // A converter which enable us to convert a CLI param to an ENUM
        commandLine.registerConverter(ResourceParameter.class, ResourceParameter::from);

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

    /**
     * The function which will be executed when the command is triggered.
     */
    @Override
    public void run() {

        logger.log(Level.INFO, "RUN METHOD");

    }
}
