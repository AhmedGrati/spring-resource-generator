package configuration.help;

import helpers.AdditionalHelpMessage;
import picocli.CommandLine;
import utils.Constants;

import java.util.LinkedHashMap;
import java.util.Map;

public class AdditionalHelpInformation {

    public static CommandLine addAnotherHelpSection(CommandLine commandLine) {

        Map<String, String> env = new LinkedHashMap<>();
        env.put(Constants.HELP_SCHEMATIC_ENTITY_NAME,Constants.HELP_SCHEMATIC_ENTITY_DESCRIPTION);
        env.put(Constants.HELP_SCHEMATIC_RESOURCE_NAME,Constants.HELP_SCHEMATIC_RESOURCE_DESCRIPTION);
        AdditionalHelpMessage additionalHelpMessage = new AdditionalHelpMessage(

                Constants.HELP_AVAILABLE_SCHEMATICS_SECTION,
                env,
                Constants.SECTION_KEY_ENV_HEADING,
                Constants.SECTION_KEY_ENV_DETAILS
        );
        commandLine = additionalHelpMessage.createAppropriateHelpMessage(commandLine);
        return commandLine;

    }
}
