import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * @author zjw
 * @package DataStructure
 * @Date 2021/9/4
 * @Time 12:27
 */
public class sparseArray {
    //定义棋盘11行11列
    private static final int row = 11;
    private static final int col = 11;


    /*创建文件*/
    public static File initFile() {
        File file = new File("稀疏数组.txt");

        if (!file.exists())
            file = new File(file.getPath());

        return file;
    }

    /*写入文件*/
    public static void WriteFile(File file, int arr[][]) throws IOException {

        FileWriter fileWriter = new FileWriter(file);

        if (arr.length == 0)
            return;

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr[0].length; j++) {

                    fileWriter.write(arr[i][j] + "\t");
            }

            if (i != arr.length - 1)
                fileWriter.write("\n");
        }

        fileWriter.close();
    }

    /*读取文件*/
    public static int[][] ReadFile(File file) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(file));

        List<String> allLines = Files.readAllLines(Paths.get(file.getPath()));

        int[][] arr = new int[allLines.size()][3];

        int i = 0;
        String line;

        while ((line = br.readLine()) != null) {
            String[] s = line.split("\t");

            for (int j = 0; j < s.length; j++) {
                    arr[i][j] = Integer.valueOf(s[j]);
            }
            i++;
        }
            br.close();
             return arr;
        }

        /*打印稀疏数组*/
    public static void printWholeArray(int arr[][]){
        int[][] wholeArray = new int[row][col];

        for (int i = 0; i < arr.length; i++) {
          wholeArray[arr[i][0]][arr[i][1]] = arr[i][2];
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(wholeArray[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }

    /*打印二维数组*/
    public static void printArray(int arr[][]){

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(arr[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }
}
