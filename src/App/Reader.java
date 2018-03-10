package App;

import java.nio.IntBuffer;

class Reader extends Application {

    Reader(MappedFile mappedFile) {
        super(mappedFile);
        readLoop();
    }

    private void readLoop() {
        IntBuffer intBuffer;
        while (true) {
            intBuffer = mappedFile.buffer.asIntBuffer();
            switch (intBuffer.get(0)) {
                case -1:
                    System.out.println("Reader ends it's job.");
                    System.exit(0);
                    break;
                case 0:
                    sleep(10);
                    break;
                case 1:
                    sumNumbers(intBuffer);
            }
        }
    }

    private void sumNumbers(IntBuffer intBuffer) {
        int num1 = intBuffer.get(), num2 = intBuffer.get();
        System.out.println("Result: " + (num1 + num2));
        intBuffer.put(0, OperatingMode.Read.mark);
        intBuffer.rewind();
    }
}
