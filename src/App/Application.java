package App;

import com.sun.istack.internal.NotNull;

abstract class Application {
    MappedFile mappedFile;

    Application(@NotNull MappedFile mappedFile) {
        this.mappedFile = mappedFile;
    }

    void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
