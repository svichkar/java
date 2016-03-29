import com.svichkar.util.ReadExcelUtil;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by konstantin on 3/28/2016.
 */
public class Main {

    public static void main (String args[]) throws IOException {
        File file = FileUtils.getFile("src\\main\\resources\\books.xlsx");

        Set<String> titles = ReadExcelUtil.readTitles(file);
        HashMap<String, List<String>> result = ReadExcelUtil.readData(file);
    }
}
