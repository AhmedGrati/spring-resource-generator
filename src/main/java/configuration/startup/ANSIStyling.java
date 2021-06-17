package configuration.startup;

import picocli.CommandLine;

public class ANSIStyling {

    public static CommandLine.Help.ColorScheme configureANSIStyling() {

        return new CommandLine.Help.ColorScheme.Builder()
                .options     (CommandLine.Help.Ansi.Style.fg_yellow)
                .parameters  (CommandLine.Help.Ansi.Style.fg_yellow)
                .optionParams(CommandLine.Help.Ansi.Style.italic)
                .errors      (CommandLine.Help.Ansi.Style.fg_red, CommandLine.Help.Ansi.Style.bold)
                .stackTraces (CommandLine.Help.Ansi.Style.italic)
                .build();
    }
}
