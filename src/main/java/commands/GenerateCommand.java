package commands;

import actions.GenerateAction;
import picocli.CommandLine;
import schematics.Entity;
import schematics.RESTApi;
import utils.CLIConfigurationConstants;

import java.util.logging.Level;
import java.util.logging.Logger;


@CommandLine.Command(name = CLIConfigurationConstants.GENERATE_COMMAND_NAME,
        aliases = {CLIConfigurationConstants.GENERATE_COMMAND_NAME_ALIAS},
        description = CLIConfigurationConstants.GENERATE_COMMAND_DESCRIPTION,
        headerHeading = CLIConfigurationConstants.HEADER_HEADING,
        synopsisHeading = CLIConfigurationConstants.SYNOPSIS_HEADING,
        descriptionHeading = CLIConfigurationConstants.DESCRIPTION_HEADING,
        parameterListHeading = CLIConfigurationConstants.PARAM_LIST_HEADING,
        optionListHeading = CLIConfigurationConstants.OPTION_LIST_HEADING
)
public class GenerateCommand implements Runnable {

    private static final Logger logger = Logger.getLogger(GenerateCommand.class.getName());


    @Override
    public void run() {
        GenerateAction generateAction = new GenerateAction();

        try {
            generateAction.execute(new Entity(new RESTApi()), "user");
        } catch (Exception e) {

            logger.log(Level.SEVERE,"ERROR");

        }
    }
}