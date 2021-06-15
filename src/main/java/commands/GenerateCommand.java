package commands;

import picocli.CommandLine;

@CommandLine.Command(name = "generate",
        description = "Generate A New Schematic.",
        headerHeading = "Usage:%n%n",
        synopsisHeading = "%n",
        descriptionHeading = "%nDescription:%n%n",
        parameterListHeading = "%nParameters:%n",
        optionListHeading = "%nOptions:%n",
        version = "1.0.0",
        mixinStandardHelpOptions = true
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
