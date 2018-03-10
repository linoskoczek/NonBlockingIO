package App;

public enum OperatingMode {

    Write("write", 1),
    Read("read", 0),
    Exit("exit", -1);

    final String value;
    final int mark;

    OperatingMode(String value, int mark) {
        this.value = value;
        this.mark = mark;
    }

    public static OperatingMode getOperatingMode(String s) {
        if (s.equalsIgnoreCase("read")) return Read;
        if (s.equalsIgnoreCase("write")) return Write;
        throw new UnsupportedOperationException("You can use only two operations: write or read");
    }

}
