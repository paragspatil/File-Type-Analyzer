package analyzer;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        File file = new File(args[0]);
        String pattern = args[1];
        String fileType = args[2];

        byte[] array = pattern.getBytes();

        try(InputStream inputStream = new FileInputStream(args[0])) {
            byte[] fileArray = inputStream.readAllBytes();
            System.out.println(isSubArray(fileArray,array,fileArray.length,array.length) ? fileType:"Unknown file type");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    static boolean isSubArray(byte A[], byte B[],
                              int n, int m)
    {
        // Two pointers to traverse the arrays
        int i = 0, j = 0;

        // Traverse both arrays simultaneously
        while (i < n && j < m)
        {

            // If element matches
            // increment both pointers
            if (A[i] == B[j])
            {

                i++;
                j++;

                // If array B is completely
                // traversed
                if (j == m)
                    return true;
            }

            // If not,
            // increment i and reset j
            else
            {
                i = i - j + 1;
                j = 0;
            }
        }
        return false;
    }
}
