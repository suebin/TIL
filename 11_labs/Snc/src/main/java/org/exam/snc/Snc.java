package org.nhnacademy.snc;

import org.apache.commons.cli.*;

/**
 * nc (netcat) 프로그램과 유사하게 동작하는 simple-nc(= snc).
 */
public class Snc {
    /**
     * Snc Options.
     *
     * @param args Snc 명령어.
     */
    public static void main(String[] args) {
        Options options = new Options();

        Option snc = Option.builder("l")
                .argName("port")
                .hasArg()
                .desc("서버 모드로 동작, 입력 받은 포트로 listen")
                .build();

        options.addOption(snc);

        options.addOption("h", "help", false, "도움말");

        CommandLineParser parser = new DefaultParser();

        try {
            CommandLine cmd = parser.parse(options, args);

            if (cmd.hasOption("h")) {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("snc", options);
            } else if (cmd.hasOption("l")) {
                Server server = new Server(args[1]);
                server.start();
            } else {
                Client client = new Client(args[0], args[1]);
                client.start();
            }
        } catch (ParseException ignore) {
            System.err.println("명령어 인수가 잘못되었습니다.");
            System.err.println(ignore.getMessage());
        }
    }
}
