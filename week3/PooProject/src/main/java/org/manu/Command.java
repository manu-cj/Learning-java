package org.manu;

public enum Command {
    HELP {
        @Override
        public String execute() {
            // Returns a list of available commands with a small description.
            return """
                    Available commands:
                    help: List all commands with a short description.
                    help <command>: Show details about a specific command.
                    monthly_total: Sum of export and import for a specified month/year.
                    monthly_average: Average of export and import for a specified month/year.
                    yearly_total: Overview of monthly totals and yearly totals for a year.
                    yearly_average: Overview of monthly averages and yearly averages for a year.
                    overview: List all unique years, countries, commodities, transport modes, and measures.
                    """;
        }

        @Override
        public String execute(String command) {
            // Returns a full explanation of the given command.
            return switch (command.toLowerCase()) {
                case "help" -> "help: Lists all available commands with a short description.";
                case "help <command>" ->
                    "help <command>: Shows a detailed explanation and parameters for the given command.";
                case "monthly_total" ->
                    "monthly_total <year> <month>: Returns the sum of export and import for the specified month and year.";
                case "monthly_average" ->
                    "monthly_average <year> <month>: Returns the average of export and import for the specified month and year.";
                case "yearly_total" ->
                    "yearly_total <year>: Returns monthly totals and yearly totals for both import and export for the specified year.";
                case "yearly_average" ->
                    "yearly_average <year>: Returns monthly averages and yearly averages for both import and export for the specified year.";
                case "overview" ->
                    "overview: Lists all unique years, countries, commodities, transportation modes, and measures in the dataset.";
                default -> "Unknown command: " + command;
            };
        }
    },
    MONTHLY_TOTAL {
        @Override
        public String execute() {
            return "monthly_total";
        }
    },
    MONTHLY_AVERAGE {
        @Override
        public String execute() {
            return "monthly_average";
        }
    },
    YEARLY_TOTAL {
        @Override
        public String execute() {
            return "yearly_total";
        }
    },
    YEARLY_AVERAGE {
        @Override
        public String execute() {
            return "yearly_average";
        }
    },
    OVERVIEW {
        @Override
        public String execute() {
            return "overview: Lists all unique years, countries, commodities, transportation modes, and measures.";
        }
    };

    public abstract String execute();

    // for help with parameter
    public String execute(String command) {
        return "This command does not support detailed help.";
    }
}
