package App;

import Exceptions.FileNotReadableOrWritableException;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

class MappedFile {

    FileChannel fileChannel;
    MappedByteBuffer buffer;

    MappedFile(File file, OperatingMode mode) {
        try {
            if (mode == OperatingMode.Write) file.delete();
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            if (!file.canRead() || !file.canWrite()) throw new FileNotReadableOrWritableException();
            fileChannel = randomAccessFile.getChannel();
            buffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 1024);
        } catch (FileNotReadableOrWritableException | IOException e) {
            e.printStackTrace();
        }
    }
}
