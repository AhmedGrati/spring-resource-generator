package configuration.startup;

import org.fusesource.jansi.AnsiConsole;

public class AnsiConsoleManagement {
    AnsiConsoleManagement() {}
    public static void install() {

        AnsiConsole.systemInstall();
    }
    public static void uninstall() {
        AnsiConsole.systemUninstall();
    }
}
