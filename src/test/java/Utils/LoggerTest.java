package Utils;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.kodigo.Utils.Logger;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoggerTest {
    private static final String PATH = "C:\\tmp\\log4j2.log";
    private static BufferedReader bufferedReader;
    private  static File file;


    @BeforeAll
    static void initializeReader() throws IOException {
        file = new File(PATH);
        bufferedReader = new BufferedReader(new FileReader(file));
    }

    @AfterAll
    static void closeReader() throws IOException {
        bufferedReader.close();
    }

    @Test
    void writeToLoggerTest() throws IOException {
        String stringToLogg = "z2mmuoeEIy";
        Logger.logError(stringToLogg);
        assertTrue(getLastLine().contains(stringToLogg));
    }

    public String getLastLine() throws IOException {
        String line = "";
        String lastLine = "";
        StringBuffer contents = new StringBuffer();
        boolean isFirst = true;
        do{
            lastLine = line;
            if(isFirst){
                isFirst = false;
            }else{
                contents.append(line+"\n");
            }

        }while((line = bufferedReader.readLine()) != null);
        contents.replace(contents.length()-(lastLine.length()+1),contents.length(),"");
        resetFile(contents.toString());
        return lastLine;
    }

    private void resetFile(String contents) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write(contents);
        bufferedWriter.close();
    }



}
