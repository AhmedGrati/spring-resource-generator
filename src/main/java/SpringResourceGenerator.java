import picocli.CommandLine;
@CommandLine.Command(name = "ASCIIArt", version = "ASCIIArt 1.0", mixinStandardHelpOptions = true)
public class SpringResourceGenerator implements Runnable{
    @CommandLine.Option(names = { "-s", "--font-size" }, description = "Font size")
    int fontSize = 19;

    @CommandLine.Parameters(paramLabel = "<word>", defaultValue = "Hello, picocli",
            description = "Words to be translated into ASCII art.")
    private String[] words = { "Hello,", "picocli" };
    public static void main(String[] args) {
        int exitCode = new CommandLine(new SpringResourceGenerator()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public void run() {

    }
}
