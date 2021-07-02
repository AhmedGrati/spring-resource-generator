package configuration.startup;

import org.fusesource.jansi.AnsiConsole;

public final class AnsiConsoleManagement {
    /**
     * Default constructor.
     */
    private AnsiConsoleManagement() {
    }

    /**
     * Install the ANSI Console on the command line for windows OS.
     */
    public static void install() {

        AnsiConsole.systemInstall();
    }

    /**
     * Uninstall the ANSI Console from the command line.
     */
    public static void uninstall() {
        AnsiConsole.systemUninstall();
    }
}
