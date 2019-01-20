package files;

import exceptions_handling.ExceptionCode;
import exceptions_handling.MyException;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GifFile implements IFile {

    private final int[] magicBytes = new int[6]; // arrays are effective-final but I need also that reference is immutable (final)
    private final List<Integer[]> correctValues = new ArrayList<>(Arrays.asList(new Integer[]{71, 73, 70, 56, 57, 97}, new Integer[]{71, 73, 70, 56, 55, 97}));

    public GifFile() {
    }

    @Override
    public boolean isFileRealExtension(String fileName) {

        File file = new File(fileName);
        try (InputStream is = new FileInputStream(file)) {
            for (int i = 0; i < this.magicBytes.length; i++) {
                this.magicBytes[i] = is.read();
            }
            if (checkPossibilities()) { // any element in list of Integer arr is the same as read from file?
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new MyException(ExceptionCode.IO_OPERATIONS, e.getMessage());
        }
    }
    // check if any of two correct possibilities is equal with read sequence
    private boolean checkPossibilities() {
        for (Integer[] e : this.correctValues) {
            if (Arrays.equals(Arrays.stream(this.magicBytes).boxed().toArray(Integer[]::new), e)) {
                return true;
            }
        }
        return false;
    }
}
