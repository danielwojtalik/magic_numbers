package files;


public interface IFile {

     // only one method, I need a guarantee every class which implements this interface will implements this method
     boolean isFileRealExtension (String fileName);
}
