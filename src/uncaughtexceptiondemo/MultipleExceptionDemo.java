package uncaughtexceptiondemo;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Logger;

public class MultipleExceptionDemo {

    private static final String FILE_PATH = "C:/Data/Formacion/Exceptions"; // Replace this path at project location in your PC

    public static void main(String[] args) throws Exception {

        Logger logger = Logger.getLogger(String.valueOf(UncaughtExceptionDemo.class));
        String executionState = "Incomplete";
        logger.info("The execution of the MultipleExceptionDemo is started");
        try {
            createFile(logger);
            executionState = "Complete";
        }
        catch (IOException ioe) {
//            logger.info(e.toString());
            throw new IOException(ioe);  // for wrong place to write file
        }
        catch (IllegalArgumentException iea) {
            iea.printStackTrace(); // Full stack trace. it can be useful in logger
            throw new IllegalArgumentException(iea);  // createTempFile prefix less than 3 characters

        }catch (ArrayIndexOutOfBoundsException aiobe){
            throw new ArrayIndexOutOfBoundsException(String.valueOf(aiobe)); // MyIntArray[ for values > 4]
        } catch ( Exception e){
             throw new Exception(e); //This is generic exception, that cover all type of exceptions, for an unexpected error!
        } finally { // It'll get executed no matter what!!!
            // Usually it used for disconnect from resources, connections or BBDD connections

            logger.info("End of the execution. Final state: ".concat(executionState));
        }

    }

    private static void createFile(Logger logger) throws IOException {

        File testF= new File(FILE_PATH);  //Haven't permission to write in /root (or wrong direction!)//UNDESTAND difference between URI and URL!!!
        File temporaryFile;

        //logger.info(FileSystemView.getFileSystemView().getHomeDirectory().toString());
        //DOcumentation https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/File.html#createTempFile(java.lang.String,java.lang.String)
        temporaryFile = File.createTempFile("te", null, testF);  // prefix of a filename > 3 char
        logger.info("Temp file name; ".concat(temporaryFile.getPath()));
        int[] myIntArray = new int[5];
        myIntArray[4] = 25;
    }


 /*   public static Path createFile(String destDir, String fileName) throws IOException {
        FileAccess.createDirectory( destDir);

        Path xpath = new Path( destDir + Path.SEPARATOR + fileName);

        if (! xpath.toFile().exists()) {
            xpath.toFile().createNewFile();
            new File(destDir).mkdirs();
            if(FileAccess.TRACE_FILE)Trace.println1("<<< createFile " + xpath.toString() );
        }
        return xpath;
    }


    public static void createDirectory(String destDir) {
        Path dirpath = new Path(destDir);
        if (! dirpath.toFile().exists()) {
            dirpath.toFile().mkdir();
            if(TRACE_FILE)Trace.println1("<<< mkdir " + dirpath.toString() );
        }
    }*/
}
