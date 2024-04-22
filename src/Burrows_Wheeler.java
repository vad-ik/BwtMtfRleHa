
import java.util.ArrayList;
import java.util.Collections;

public class Burrows_Wheeler {
    char end = (char) 65520;

    public StringBuilder decompressEffective(StringBuilder str) {
        ArrayList<BWTtranspositionObject> map = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            map.add(new BWTtranspositionObject(i, str.charAt(i)));
        }
        Collections.sort(map);

        int n = 0;
        for (BWTtranspositionObject bwTtranspositionObject : map) {
            if (bwTtranspositionObject.character == end) {
                break;
            }
            n++;
        }

        n = map.get(n).getNum();
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < map.size() - 1; i++) {
            out.append(map.get(n).getCharacter());
            n = map.get(n).getNum();
        }
        return out;
    }

}
