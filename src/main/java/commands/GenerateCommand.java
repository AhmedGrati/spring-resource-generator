package commands;

import actions.GenerateAction;
import picocli.CommandLine;
import schematics.Entity;
import schematics.RESTApi;
import utils.CLIConfigurationConstants;


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


    @Override
    public void run() {
        GenerateAction generateAction = new GenerateAction();

        try {
            generateAction.execute(new Entity(new RESTApi()), "user");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}