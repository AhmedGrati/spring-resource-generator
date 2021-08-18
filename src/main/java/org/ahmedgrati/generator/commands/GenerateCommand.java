package org.ahmedgrati.generator.commands;

import org.ahmedgrati.generator.actions.GenerateAction;
import org.ahmedgrati.generator.utils.CLIConfigurationConstants;
import org.ahmedgrati.generator.utils.ResourceParameter;
import picocli.CommandLine;


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

    /**
     * Logger.
     */
    private static final Logger LOGGER = Logger.getLogger(GenerateCommand.class.getName());


    @CommandLine.Option(names = {"-g", "--groupid"}, description = "Specify The Group ID Of The Project", required = true)
    private String groupId;

    @CommandLine.Parameters(index = "0", description = "Resource To Generate")
    ResourceParameter resource;


    @CommandLine.Parameters(index = "1", description = "Resource Name")
    String resourceName;

    /**
     * Function which will be executed when the generate command is triggered.
     */
    @Override
    public void run() {
        GenerateAction generateAction = new GenerateAction();
        try {
            generateAction.execute(resource, resourceName, groupId);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "ERROR");
        }
    }
}
