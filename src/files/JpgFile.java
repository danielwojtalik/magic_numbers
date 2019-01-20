package files;

import exceptions_handling.ExceptionCode;
import exceptions_handling.MyException;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;

public class JpgFile implements IFile {


    private final int[] magicBytes = new int[2];
    private final int[] correctValues = {255, 216};

    public JpgFile() {
    }

    @Override
    public boolean isFileRealExtension(String fileName) {
        File file = new File(fileName);
        try (InputStream is = new FileInputStream(file)) {
            for (int i = 0; i < this.correctValues.length; i++) {
                this.magicBytes[i] = is.read();
            }
            if (Arrays.equals(this.correctValues, this.magicBytes)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new MyException(ExceptionCode.IO_OPERATIONS, e.getMessage());
        }
    }
}
