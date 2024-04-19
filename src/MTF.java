import java.util.ArrayList;
import java.util.Collections;

public class MTF {
    public StringBuilder compress(StringBuilder str) {
        ArrayList<Character> alphabet = Stats.getAlphabet(String.valueOf(str));
        ArrayList<Integer> strOut = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            int j = 0;
            while (str.charAt(i) != alphabet.get(j)) {
                j++;
            }
            strOut.add(j);
            alphabet.remove(j);
            alphabet.add(0, str.charAt(i));
        }
        return toStr(alphabet, strOut);
        // onFile(alphabet,strOut);
    }

    public StringBuilder toStr(ArrayList<Character> alphabet, ArrayList<Integer> strOut) {
        StringBuilder out = new StringBuilder();
        out.append(((char) alphabet.size()));
        Collections.sort(alphabet);
        for (Character character : alphabet) {
            out.append(character);

        }
        for (int integer : strOut) {
            out.append((char) (integer + 1));
        }
        return out;
    }


    public StringBuilder deCompress(StringBuilder str) {
        ArrayList<Character> alphabet = new ArrayList<>();

        int alpSize = str.charAt(0);
        for (int i = 1; i < alpSize + 1; i++) {
            alphabet.add(str.charAt(i));
        }
        StringBuilder strOut = new StringBuilder();
        for (int i = alpSize + 1; i < str.length(); i++) {
            int n = str.charAt(i)-1;
            strOut.append(alphabet.get(n));
            alphabet.add(0, alphabet.get(n));
            alphabet.remove(n + 1);
        }
        return (strOut);

    }

}
