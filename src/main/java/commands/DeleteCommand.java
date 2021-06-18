package commands;

import picocli.CommandLine;
import utils.Constants;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
@CommandLine.Command(name = Constants.DELETE_COMMAND_NAME,
        aliases = {Constants.DELETE_COMMAND_NAME_ALIAS},
        description = Constants.DELETE_COMMAND_DESCRIPTION,
        headerHeading = Constants.HEADER_HEADING,
        synopsisHeading = Constants.SYNOPSIS_HEADING,
        descriptionHeading = Constants.DESCRIPTION_HEADING,
        parameterListHeading = Constants.PARAM_LIST_HEADING,
        optionListHeading = Constants.OPTION_LIST_HEADING
)
public class DeleteCommand implements Runnable {

    public final Logger logger = Logger.getLogger(DeleteCommand.class.getName());


    @Override
    public void run() {
        logger.log(Level.INFO, "IMPLEMENTATION OF DELETE COMMAND RUN");
    }
}
