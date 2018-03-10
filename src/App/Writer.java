package App;

import java.nio.IntBuffer;
import java.util.Random;

class Writer extends Application {

    private final Random RANDOM = new Random();

    Writer(MappedFile mappedFile) {
        super(mappedFile);
        writeLoop(10);
    }

    private void writeLoop(int iterations) {
        IntBuffer intBuffer = mappedFile.buffer.asIntBuffer();
        for (int i = 0; i < iterations; i++) {
            if (intBuffer.limit() == 0)
                writeRandomNumbers(intBuffer);
            else {
                switch (intBuffer.get(0)) {
                    case -1:
                        System.out.println("Writer ends it's job.");
                        System.exit(0);
                        break;
                    case 1:
                        sleep(10);
                        i--;
                        break;
                    case 0:
                        writeRandomNumbers(intBuffer);
                }
            }
        }
        writeExitMark(intBuffer);
    }

    private void writeExitMark(IntBuffer intBuffer) {
        while (intBuffer.limit() == 0 || intBuffer.get(0) != OperatingMode.Read.mark) {
            sleep(10);
        }
        intBuffer
                .put(OperatingMode.Exit.mark)
                .rewind();
        System.out.println("Writer ends it's job.");
        System.exit(0);
    }

    private void writeRandomNumbers(IntBuffer intBuffer) {
        intBuffer
                .put(OperatingMode.Write.mark)
                .put(RANDOM.nextInt())
                .put(RANDOM.nextInt())
                .rewind();
    }
}
