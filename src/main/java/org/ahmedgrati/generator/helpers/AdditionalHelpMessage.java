package org.ahmedgrati.generator.helpers;

import picocli.CommandLine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AdditionalHelpMessage {
    /**
     * The header of the additional help message to be displayed.
     */
    private String headerOfAdditionalHelpMessage;
    /**
     * The actual help message.
     */
    private Map<String, String> additionalMessageHelp;
    /**
     * The key of the header of help message.
     */
    private String keyOfHeader;
    /**
     * The key of the details of help message.
     */
    private String keyOfDetails;


    /**
     * @param headerOfAdditionalHelpMessageParam
     * @param additionalMessageHelpParam
     * @param keyOfHeaderParam
     * @param keyOfDetailsParam
     */
    public AdditionalHelpMessage(
            final String headerOfAdditionalHelpMessageParam,
            final Map<String, String> additionalMessageHelpParam,
            final String keyOfHeaderParam,
            final String keyOfDetailsParam
    ) {
        this.headerOfAdditionalHelpMessage = headerOfAdditionalHelpMessageParam;
        this.additionalMessageHelp = additionalMessageHelpParam;
        this.keyOfHeader = keyOfHeaderParam;
        this.keyOfDetails = keyOfDetailsParam;
    }

    /**
     * @param commandLine
     * @return CommandLine
     */
    public CommandLine createAppropriateHelpMessage(final CommandLine commandLine) {

        // Create the Header of the additional Section Help
        commandLine.getHelpSectionMap().put(
                keyOfHeader,
                help -> help.createHeading(headerOfAdditionalHelpMessage));

        // Create the description of the additional help
        commandLine.getHelpSectionMap().put(
                keyOfDetails,
                help -> help.createTextTable(additionalMessageHelp).toString());

        List<String> keys = new ArrayList<>(commandLine.getHelpSectionKeys());

        int index = keys.indexOf(CommandLine.Model.UsageMessageSpec.SECTION_KEY_FOOTER_HEADING);
        keys.add(index, keyOfHeader);
        keys.add(index + 1, keyOfDetails);
        commandLine.setHelpSectionKeys(keys);

        return commandLine;

    }

}
