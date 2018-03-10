package App;

import java.io.File;

public class Launcher {

    private static final File DEFAULT_FILE = new File("CALC");

    public static void main(String[] args) {
        validateArguments(args);
        OperatingMode operatingMode = OperatingMode.getOperatingMode(args[0]);

        MappedFile mappedFile;
        switch (operatingMode) {
            case Read:
                mappedFile = new MappedFile(DEFAULT_FILE, OperatingMode.Read);
                new Reader(mappedFile);
                break;
            case Write:
                mappedFile = new MappedFile(DEFAULT_FILE, OperatingMode.Write);
                new Writer(mappedFile);
        }
    }

    private static void validateArguments(String[] args) {
        if (args.length == 0)
            throw new IllegalArgumentException("You should provide 'write' or 'read' operation if you want to start.");
    }
}
