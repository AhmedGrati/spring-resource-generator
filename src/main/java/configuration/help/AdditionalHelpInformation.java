package configuration.help;

import helpers.AdditionalHelpMessage;
import picocli.CommandLine;
import utils.CLIConfigurationConstants;

import java.util.LinkedHashMap;
import java.util.Map;

public class AdditionalHelpInformation {


    AdditionalHelpInformation() {

    }

    public static CommandLine addAnotherHelpSection(CommandLine commandLine) {

        Map<String, String> env = new LinkedHashMap<>();
        env.put(CLIConfigurationConstants.HELP_SCHEMATIC_ENTITY_NAME, CLIConfigurationConstants.HELP_SCHEMATIC_ENTITY_DESCRIPTION);
        env.put(CLIConfigurationConstants.HELP_SCHEMATIC_RESOURCE_NAME, CLIConfigurationConstants.HELP_SCHEMATIC_RESOURCE_DESCRIPTION);
        AdditionalHelpMessage additionalHelpMessage = new AdditionalHelpMessage(

                CLIConfigurationConstants.HELP_AVAILABLE_SCHEMATICS_SECTION,
                env,
                CLIConfigurationConstants.SECTION_KEY_ENV_HEADING,
                CLIConfigurationConstants.SECTION_KEY_ENV_DETAILS
        );
        commandLine = additionalHelpMessage.createAppropriateHelpMessage(commandLine);
        return commandLine;

    }
}
