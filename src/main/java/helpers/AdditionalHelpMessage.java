package helpers;
import picocli.CommandLine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AdditionalHelpMessage {
    private String headerOfAdditionalHelpMessage;
    private Map<String, String> additionalMessageHelp;
    private String keyOfHeader;
    private String keyOfDetails;

    public String getHeaderOfAdditionalHelpMessage() {
        return headerOfAdditionalHelpMessage;
    }

    public void setHeaderOfAdditionalHelpMessage(String headerOfAdditionalHelpMessage) {
        this.headerOfAdditionalHelpMessage = headerOfAdditionalHelpMessage;
    }

    public Map<String, String> getAdditionalMessageHelp() {
        return additionalMessageHelp;
    }

    public void setAdditionalMessageHelp(Map<String, String> additionalMessageHelp) {
        this.additionalMessageHelp = additionalMessageHelp;
    }

    public String getKeyOfHeader() {
        return keyOfHeader;
    }

    public void setKeyOfHeader(String keyOfHeader) {
        this.keyOfHeader = keyOfHeader;
    }

    public String getKeyOfDetails() {
        return keyOfDetails;
    }

    public void setKeyOfDetails(String keyOfDetails) {
        this.keyOfDetails = keyOfDetails;
    }

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

    /**
     * @param commandLine
     * @return
     */
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
