package utils;


public final class CLIConfigurationConstants {
    private CLIConfigurationConstants() {
    }

    /**
     * Key of the heading of the help section.
     */
    public static final String SECTION_KEY_ENV_HEADING = "environmentVariables";
    /**
     * Key of the details of the help section.
     */
    public static final String SECTION_KEY_ENV_DETAILS = "environmentVariablesDetails";

    /**
     * available schematics header.
     */
    public static final String HELP_AVAILABLE_SCHEMATICS_SECTION = "\nAvailable Schematics:%n";
    /**
     * Displayed name of the generate command.
     */
    public static final String GENERATE_COMMAND_NAME = "generate";
    /**
     * Displayed alias of the generate command.
     */
    public static final String GENERATE_COMMAND_NAME_ALIAS = "g";
    /**
     * Displayed name of the delete command.
     */
    public static final String DELETE_COMMAND_NAME = "delete";
    /**
     * Displayed alias of the delete command.
     */
    public static final String DELETE_COMMAND_NAME_ALIAS = "d";
    /**
     * The displayed description of the generate command.
     */
    public static final String GENERATE_COMMAND_DESCRIPTION = "Generate A New Schematic.";
    /**
     * The heading of the header of command line.
     */
    public static final String HEADER_HEADING = "Usage:%n%n";
    /**
     * The heading of the synopsis of the command line.
     */
    public static final String SYNOPSIS_HEADING = "%n";
    /**
     * The heading of the description of the command line.
     */
    public static final String DESCRIPTION_HEADING = "%nDescription:%n%n";
    /**
     * The heading of the param list of the command line.
     */
    public static final String PARAM_LIST_HEADING = "%nParameters:%n";
    /**
     * The heading of the option list of the command line.
     */
    public static final String OPTION_LIST_HEADING = "%nOptions:%n";
    /**
     * The displayed description of the delete command.
     */
    public static final String DELETE_COMMAND_DESCRIPTION = "Delete An Existed Schematic.";
    /**
     * The version of the command line.
     */
    public static final String VERSION = "1.0.0";
    /**
     * The command line description using ANSI Colors.
     */
    public static final String SPRING_GENERATOR_COMMAND_DESCRIPTION = "@|fg(green) A Command Line Which Helps Spring Developers To Manage Schematic Easily. |@";
    /**
     * The command line header using ANSI Colors.
     */
    public static final String SPRING_GENERATOR_COMMAND_HEADER = "@|fg(green) A CLI Tool For Spring Applications.|@";
    /**
     * The command line name.
     */
    public static final String SPRING_GENERATOR_COMMAND_NAME = "spring-generator ";
    /**
     * Entity displayed name using ANSI Colors.
     */
    public static final String HELP_SCHEMATIC_ENTITY_NAME = "@|fg(39) entity,en|@";
    /**
     * Entity displayed description using ANSI Colors.
     */
    public static final String HELP_SCHEMATIC_ENTITY_DESCRIPTION = "@|fg(green) Create/Delete An Entity.|@";

    /**
     * Resource displayed name using ANSI Colors.
     */
    public static final String HELP_SCHEMATIC_RESOURCE_NAME = "@|fg(39) resource,res|@";
    /**
     * Resource displayed description using ANSI Colors.
     */
    public static final String HELP_SCHEMATIC_RESOURCE_DESCRIPTION = "@|fg(green) Create/Delete An CRUD Resource.|@";

}
