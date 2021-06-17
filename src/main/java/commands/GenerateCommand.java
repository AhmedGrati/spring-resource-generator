package commands;

import picocli.CommandLine;
import utils.Constants;

@CommandLine.Command(name = Constants.GENERATE_COMMAND_NAME,
        aliases = {Constants.GENERATE_COMMAND_NAME_ALIAS},
        description = Constants.GENERATE_COMMAND_DESCRIPTION,
        headerHeading = Constants.HEADER_HEADING,
        synopsisHeading = Constants.SYNOPSIS_HEADING,
        descriptionHeading = Constants.DESCRIPTION_HEADING,
        parameterListHeading = Constants.PARAM_LIST_HEADING,
        optionListHeading = Constants.OPTION_LIST_HEADING
)
public class GenerateCommand implements Runnable {

    @CommandLine.Option(names = { "-s", "--font-size" }, description = "Font size")
    int fontSize = 19;

    @CommandLine.Parameters(paramLabel = "<word>", defaultValue = "Hello, picocli",
            description = "Words to be translated into ASCII art.")
    private String[] words = { "Hello,", "picocli" };



    @Override
    public void run() {
        System.out.println("BELEHI EKTEB L HELP");
    }
}
