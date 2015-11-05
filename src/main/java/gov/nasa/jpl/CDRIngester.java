package gov.nasa.jpl;

import org.apache.commons.cli.*;

class CDRIngester {
    public static void main(String args[]) throws ParseException {
        Options options = new Options();
        options.addOption("h", "help", false, "Show Help");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            showHelp(options);
        }

        if (cmd.hasOption("help")) {
            showHelp(options);
        }
    }

    private static void showHelp(Options options) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("CDRIngester", options);
        System.exit(0);
    }
}
