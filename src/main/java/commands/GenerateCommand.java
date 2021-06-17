package commands;

import picocli.CommandLine;
import utils.Constants;

import java.util.logging.Level;
import java.util.logging.Logger;

@CommandLine.Command(name = Constants.GENERATE_COMMAND_NAME,
        aliases = {Constants.GENERATE_COMMAND_NAME_ALIAS},
        description = Constants.GENERATE_COMMAND_DESCRIPTION,
        headerHeading = Constants.HEADER_HEADING,
        synopsisHeading = Constants.SYNOPSIS_HEADING,
        descriptionHeading = Constants.DESCRIPTION_HEADING,
        parameterListHeading = Constants.PARAM_LIST_HEADING,
        optionListHeading = Constants.OPTION_LIST_HEADING
)
public class GenerateCommand implements Runnable {

    public final Logger logger = Logger.getLogger(GenerateCommand.class.getName());

    @Override
    public void run() {
        logger.log(Level.INFO, "IMPLEMENTATION OF GENERATE COMMAND");
    }
}
