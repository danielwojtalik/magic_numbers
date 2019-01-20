package files;


import exceptions_handling.ExceptionCode;
import exceptions_handling.MyException;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;

public class PdfFile implements IFile {

    private final int[] magicBytes = new int[4];
    private final int[] correctValues = {37, 80, 68, 70};

    public PdfFile() {
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


