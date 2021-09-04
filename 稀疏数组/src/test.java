import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author zjw
 * @package DataStructure
 * @Date 2021/9/4
 * @Time 14:36
 */
public class test {
    public static void main(String[] args) {
        File file = sparseArray.initFile();
        int arr[][] = {{1,2,1},{2,3,2}};

        try {
            sparseArray.WriteFile(file,arr);
        } catch (IOException e) {
            e.printStackTrace();
        }

       
        try {
            int[][] ints = sparseArray.ReadFile(file);
            sparseArray.printWholeArray(ints);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
