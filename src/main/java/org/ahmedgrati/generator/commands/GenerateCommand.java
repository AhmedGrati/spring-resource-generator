package org.ahmedgrati.generator.commands;

import org.ahmedgrati.generator.actions.GenerateAction;
import org.ahmedgrati.generator.schematics.Entity;
import org.ahmedgrati.generator.schematics.RESTApi;
import org.ahmedgrati.generator.utils.CLIConfigurationConstants;
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


    /**
     * Function which will be executed when the generate command is triggered.
     */
    @Override
    public void run() {
        GenerateAction generateAction = new GenerateAction();

        try {
            generateAction.execute(new Entity(new RESTApi()), "user");
        } catch (Exception e) {

            LOGGER.log(Level.SEVERE, "ERROR");


        }
    }
}
