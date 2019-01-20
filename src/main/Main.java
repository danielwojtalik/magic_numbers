package main;

import exceptions_handling.MyException;
import file_operations.FileOperations;

public class Main {

    public static void main(String[] args) {

        try{
            FileOperations.testYourFile("PDF.pdf"); // real pdf file
            System.out.println();
        }catch (MyException e){
            e.printStackTrace();
            System.err.println(e.getExceptionInfo().getExceptionCode());
            System.err.println(e.getExceptionInfo().getDescription());
            System.err.println(e.getExceptionInfo().getExceptionTime());
        }

        try{
            FileOperations.testYourFile("GIF.gif"); // real gif file
            System.out.println();
        }catch (MyException e){
            e.printStackTrace();
            System.err.println(e.getExceptionInfo().getExceptionCode());
            System.err.println(e.getExceptionInfo().getDescription());
            System.err.println(e.getExceptionInfo().getExceptionTime());
        }

        try{
            FileOperations.testYourFile("JPG.jpg"); // real jpg file
            System.out.println();
        }catch (MyException e){
            e.printStackTrace();
            System.err.println(e.getExceptionInfo().getExceptionCode());
            System.err.println(e.getExceptionInfo().getDescription());
            System.err.println(e.getExceptionInfo().getExceptionTime());
        }

        try{
            FileOperations.testYourFile("fake_GIF_real_PDF.gif"); // fake gif
            System.out.println();
        }catch (MyException e){
            e.printStackTrace();
            System.err.println(e.getExceptionInfo().getExceptionCode());
            System.err.println(e.getExceptionInfo().getDescription());
            System.err.println(e.getExceptionInfo().getExceptionTime());
        }

        try{
            FileOperations.testYourFile("fake_JPG_real_GIF.jpg"); // fake jpg
            System.out.println();
        }catch (MyException e){
            e.printStackTrace();
            System.err.println(e.getExceptionInfo().getExceptionCode());
            System.err.println(e.getExceptionInfo().getDescription());
            System.err.println(e.getExceptionInfo().getExceptionTime());
        }

        try{
            FileOperations.testYourFile("fake_PDF_real_GIF.pdf"); // fake pdf
            System.out.println();
        }catch (MyException e){
            e.printStackTrace();
            System.err.println(e.getExceptionInfo().getExceptionCode());
            System.err.println(e.getExceptionInfo().getDescription());
            System.err.println(e.getExceptionInfo().getExceptionTime());
        }

        try{
            FileOperations.testYourFile("sample.pdf"); // supported extension but file not exists
            System.out.println();
        }catch (MyException e){
            //e.printStackTrace();
            System.err.println(e.getExceptionInfo().getExceptionCode());
            System.err.println(e.getExceptionInfo().getDescription());
            System.err.println(e.getExceptionInfo().getExceptionTime());
        }

        try{
            FileOperations.testYourFile("DOCX.docx"); // unsupported extension and file exists
            System.out.println();
        }catch (MyException e){
            //e.printStackTrace();
            System.err.println(e.getExceptionInfo().getExceptionCode());
            System.err.println(e.getExceptionInfo().getDescription());
            System.err.println(e.getExceptionInfo().getExceptionTime());
        }
    }
}
