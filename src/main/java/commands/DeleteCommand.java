package commands;

import picocli.CommandLine;
import utils.CLIConfigurationConstants;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
@CommandLine.Command(name = CLIConfigurationConstants.DELETE_COMMAND_NAME,
        aliases = {CLIConfigurationConstants.DELETE_COMMAND_NAME_ALIAS},
        description = CLIConfigurationConstants.DELETE_COMMAND_DESCRIPTION,
        headerHeading = CLIConfigurationConstants.HEADER_HEADING,
        synopsisHeading = CLIConfigurationConstants.SYNOPSIS_HEADING,
        descriptionHeading = CLIConfigurationConstants.DESCRIPTION_HEADING,
        parameterListHeading = CLIConfigurationConstants.PARAM_LIST_HEADING,
        optionListHeading = CLIConfigurationConstants.OPTION_LIST_HEADING
)
public class DeleteCommand implements Runnable {

    public final Logger logger = Logger.getLogger(DeleteCommand.class.getName());


    @Override
    public void run() {
        logger.log(Level.INFO, "IMPLEMENTATION OF DELETE COMMAND RUN");
    }
}
