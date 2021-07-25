package org.ahmedgrati.generator.configuration.help;

import org.ahmedgrati.generator.helpers.AdditionalHelpMessage;
import org.ahmedgrati.generator.utils.CLIConfigurationConstants;
import picocli.CommandLine;

import java.util.LinkedHashMap;
import java.util.Map;

public final class AdditionalHelpInformation {


    private AdditionalHelpInformation() {

    }

    /**
     * @param commandLine
     * @return CommandLine
     */
    public static CommandLine addAnotherHelpSection(final CommandLine commandLine) {

        Map<String, String> env = new LinkedHashMap<>();
        env.put(
                CLIConfigurationConstants.HELP_SCHEMATIC_ENTITY_NAME,
                CLIConfigurationConstants.HELP_SCHEMATIC_ENTITY_DESCRIPTION
        );
        env.put(
                CLIConfigurationConstants.HELP_SCHEMATIC_RESOURCE_NAME,
                CLIConfigurationConstants.HELP_SCHEMATIC_RESOURCE_DESCRIPTION
        );
        AdditionalHelpMessage additionalHelpMessage = new AdditionalHelpMessage(

                CLIConfigurationConstants.HELP_AVAILABLE_SCHEMATICS_SECTION,
                env,
                CLIConfigurationConstants.SECTION_KEY_ENV_HEADING,
                CLIConfigurationConstants.SECTION_KEY_ENV_DETAILS
        );
        return additionalHelpMessage.createAppropriateHelpMessage(commandLine);
    }
}
