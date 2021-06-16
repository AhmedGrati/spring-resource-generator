import commands.DeleteCommand;
import commands.GenerateCommand;
import helpers.AdditionalHelpMessage;
import picocli.CommandLine;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@CommandLine.Command(name = "spring-generator",subcommands = {DeleteCommand.class,GenerateCommand.class},
        version = "1.0.0",

        description = "@|fg(red) A Command Line Which Helps Spring Developers To Manage Schematic Easily. |@",
        headerHeading = "Usage:%n%n",
        synopsisHeading = "%n",
        descriptionHeading = "%nDescription:%n%n",
        parameterListHeading = "%nParameters:%n",
        optionListHeading = "%nOptions:%n",
        header = "A CLI Tool For Spring Applications.",
        mixinStandardHelpOptions = true)
public class SpringResourceGenerator implements Runnable{




    public static void main(String[] args) {
        CommandLine commandLine = new CommandLine(new SpringResourceGenerator());
        final String SECTION_KEY_ENV_HEADING = "environmentVariables";
        final String SECTION_KEY_ENV_DETAILS = "environmentVariablesDetails";

        final String header = "\nAvailable Schematics:%n";
        Map<String, String> env = new LinkedHashMap<>();
        env.put("entity|en","@|fg(red) Create/Delete An Entity.|@");
        env.put("resource|res","Create/Delete A CRUD Resource.");
        CommandLine.Help.ColorScheme colorScheme = new CommandLine.Help.ColorScheme.Builder()
                .commands    (CommandLine.Help.Ansi.Style.bold, CommandLine.Help.Ansi.Style.underline)    // combine multiple styles
                .options     (CommandLine.Help.Ansi.Style.fg_yellow)                // yellow foreground color
                .parameters  (CommandLine.Help.Ansi.Style.fg_yellow)
                .optionParams(CommandLine.Help.Ansi.Style.italic)
                .errors      (CommandLine.Help.Ansi.Style.fg_red, CommandLine.Help.Ansi.Style.bold)
                .stackTraces (CommandLine.Help.Ansi.Style.italic)
                .build();
//        cmd.getHelpSectionMap().put(SECTION_KEY_ENV_HEADING, help ->
//
//            help.createHeading("Available Schematics:%n")
//        );
//
//        cmd.getHelpSectionMap().put(SECTION_KEY_ENV_DETAILS,
//                help -> help.createTextTable(env).toString());
//
//        // specify the location of the new sections
//        List<String> keys = new ArrayList<>(cmd.getHelpSectionKeys());
//
//
        AdditionalHelpMessage additionalHelpMessage = new AdditionalHelpMessage(

                header,
                env,
                SECTION_KEY_ENV_HEADING,
                SECTION_KEY_ENV_DETAILS
        );
        commandLine = additionalHelpMessage.createAppropriateHelpMessage(commandLine);
        commandLine.setColorScheme(colorScheme);
        
        int exitCode = commandLine.execute(args);

        System.exit(exitCode);
    }

    @Override
    public void run() {

    }
}
