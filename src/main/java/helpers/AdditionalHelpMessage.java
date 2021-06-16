package helpers;
import picocli.CommandLine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AdditionalHelpMessage {
    public String headerOfAdditionalHelpMessage;
    public Map<String, String> additionalMessageHelp;
    public String keyOfHeader;
    public String keyOfDetails;

    public AdditionalHelpMessage(
            String headerOfAdditionalHelpMessage,
            Map<String, String> additionalMessageHelp,
            String keyOfHeader,
            String keyOfDetails
    ) {
        this.headerOfAdditionalHelpMessage = headerOfAdditionalHelpMessage;
        this.additionalMessageHelp = additionalMessageHelp;
        this.keyOfHeader = keyOfHeader;
        this.keyOfDetails = keyOfDetails;
    }

    /*
    @params commandLine command line which we want to mutate in order to add the additional section in the help message
    * **/
    public CommandLine createAppropriateHelpMessage(CommandLine commandLine) {

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
