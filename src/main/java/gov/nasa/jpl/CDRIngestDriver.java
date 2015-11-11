package gov.nasa.jpl;

import java.io.File;

import org.apache.commons.cli.*;

public class CDRIngestDriver {
    public static void main(String args[]) throws ParseException {
        Options options = new Options();
        options.addOption("h", "help", false, "Show Help");
        options.addOption(Option.builder("c")
                                .longOpt("config")
                                .hasArg()
                                .argName("PATH")
                                .desc("path to TitanDB Properties configuration file")
                                .build());

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

        CDRIngester ingester = null;

        if (cmd.hasOption("config")) {
            ingester = new CDRIngester(new File(cmd.getOptionValue("config")));
        } else {
            ingester = new CDRIngester();
        }

        ingester.ingestToCDR();
    }

    private static void showHelp(Options options) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("CDRIngester", options);
        System.exit(0);
    }
}
