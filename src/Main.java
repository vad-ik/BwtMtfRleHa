import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Huffman huffman = new Huffman();
        RLE rle = new RLE();
        BWTFast burrowsWheeler = new BWTFast();
        MTF mtf = new MTF();
        Burrows_Wheeler bwt = new Burrows_Wheeler();

        String path;
        StringBuilder strIn;

        System.out.println("введите путь к сжимаемому файлу");
        path= scanner.nextLine();
        strIn = readFile( path);
        System.out.println("введите путь к  каталогу, где будут созданы новые файлы");
        path = scanner.nextLine();


        huffman.codingInFileToBit(rle.coderV2(mtf.compress(burrowsWheeler.getBWT(strIn))), path + "\\bwtMtfRLeHaCompress.txt");
        StringBuilder str=mtf.deCompress(rle.autoDeCompression(huffman.decodingBit(path + "\\bwtMtfRLeHaCompress.txt")));
        System.gc();
        toFile(bwt.decompressEffective(str), path + "\\bwtMtfRLeHaDeCompress.txt");
    }

    static void toFile(StringBuilder str, String path) {
        try {
            FileWriter writer = new FileWriter(path, false);
            writer.write(str.toString());
            writer.flush();
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static StringBuilder readFile(String path) {
        StringBuilder strIn = new StringBuilder();
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader(path));
//            String line;
//            while ((line = reader.readLine()) != null) {
//                strIn.append(line);
//                strIn.append("\n");
//            }
//            reader.close();
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        try {
            FileReader reader = new FileReader(new File(path));
            int c;
            while ((c = reader.read()) != -1) {
                strIn.append((char) c);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return strIn;
    }
}

