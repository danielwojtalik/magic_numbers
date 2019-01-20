package file_operations;

import exceptions_handling.ExceptionCode;
import exceptions_handling.MyException;
import files.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public abstract class FileOperations { // this class is abstract, cause i create here only static methods, i don't need initialized it in the future

    private final static List<String> handledExtension = new ArrayList<>(Arrays.asList(".PDF", ".JPG", ".GIF")); // Extension which are handled in app

    public static void testYourFile(String fileName) {

        // User info:
        System.out.println("<---THIS PROGRAM SUPPORT .jpg, .gif, .pdf EXTENSIONS--->");
        System.out.println("YOUR FILE IS: " + fileName);

        // throw MyException if, file extension is unsupported
        if (handledExtension.stream().filter(ex -> ex.equalsIgnoreCase(getFileExtension(fileName))).collect(Collectors.toList()).isEmpty()) {
            throw new MyException(ExceptionCode.FILE_OPERATIONS, getFileExtension(fileName) + " IS UNSUPPORTED EXTENSION");
        }
        // create appropriate instance by using Runtime polymorphism and use this method to examine the file
        IFile IFile = getInstance(getFileExtension(fileName));
        if (IFile.isFileRealExtension(fileName)) {
            System.out.println("THIS IS REAL FILE WITH EXTENSION " + getFileExtension(fileName));
        } else  {
            for (String s : handledExtension) {
                IFile IFile2 = getInstance(s);
                if (IFile2.isFileRealExtension(fileName)) {
                    System.out.println("THIS FILE IS NOT " + getFileExtension(fileName).toUpperCase() + ", IN REAL THIS IS " + s + " FILE");
                    break;
                }
            }
        }
    }

    // take extension from file
    public static String getFileExtension(String fileName) {
        try {
            if (fileName == null) {
                throw new NullPointerException("FILE NAME IS NULL");
            }
            return fileName.substring(fileName.lastIndexOf("."));
        } catch (Exception e) {
            throw new MyException(ExceptionCode.FILE_OPERATIONS, e.getMessage());
        }
    }

    // return appropriate implementation IFile interface
    public static IFile getInstance(String extension) {
        if (extension.equalsIgnoreCase(".PDF")) {
            return new PdfFile();
        } else if (extension.equalsIgnoreCase(".JPG")) {
            return new JpgFile();
        } else if (extension.equalsIgnoreCase(".GIF")) {
            return new GifFile();
        } else {
            throw new MyException(ExceptionCode.FILE_OPERATIONS, "OUR PROGRAM DOES NOT SUPPORT " + extension + " EXTENSION");
        }
    }
}