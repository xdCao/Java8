package ch2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author: buku.ch
 * @Date: 2018-12-25 10:52
 */


public class Example3 {


    public static String processFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))){
            return br.readLine();
        }
    }

    @FunctionalInterface
    interface BufferedReaderProcessor {
        String process(BufferedReader b) throws IOException;
    }

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))){
            return p.process(br);
        }
    }

    public static void main(String[] args) throws IOException {
        String result = processFile((BufferedReader br) -> br.readLine());
    }

}
