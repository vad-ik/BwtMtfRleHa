import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Huffman huffman = new Huffman();
        RLE rle = new RLE();
        BWTFast burrowsWheeler = new BWTFast();
        MTF mtf = new MTF();
        Burrows_Wheeler bwt = new Burrows_Wheeler();


        Scanner scanner = new Scanner(System.in);
        System.out.println("введите путь к сжимаемому файлу");
        String path = scanner.nextLine();
        StringBuilder strIn = readFile( path);
        System.out.println("введите путь для нового файла ");
        path = scanner.nextLine();
        huffman.codingInFileToBit((rle.avtoCompress((mtf.compress((burrowsWheeler.getBWT((strIn))))))), path+"\\bwtMtfRLeHaCompress.txt");
        toFile(bwt.decompressEffective(mtf.deCompress(rle.autoDeCompression(huffman.decodingBit(path+"\\bwtMtfRLeHaCompress.txt")))),path+"\\bwtMtfRLeHaDeCompress.txt");

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
    public static StringBuilder readFile(String path){
        StringBuilder strIn = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = reader.readLine()) != null) {
                strIn.append(line);
                strIn.append("\n");
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return strIn;
    }
}

