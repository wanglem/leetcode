import java.util.*;

class IntegerToRoman {
    
    public String intToRoman(int num) {
        TreeMap<Integer, String> lut = new TreeMap<>();
        lut.put(1,"I");
        lut.put(5,"V");
        lut.put(10,"X");
        lut.put(50,"L");
        lut.put(100,"C");
        lut.put(500,"D");
        lut.put(1000,"M");
        lut.put(4,"IV");
        lut.put(9,"IX");
        lut.put(40,"XL");
        lut.put(90,"XC");
        lut.put(400,"CD");
        lut.put(900,"CM");

        List<Map.Entry<Integer, String>> ordered = new ArrayList<>(lut.entrySet());

        StringBuilder sb = new StringBuilder();
        for (int i = ordered.size()-1; i >= 0; i-- ) {
            if (num >= ordered.get(i).getKey()) {
                for (int j = 0; j < num / ordered.get(i).getKey(); j++) {
                    sb.append(ordered.get(i).getValue());
                }
                num = num % ordered.get(i).getKey();
            }
        }
        return sb.toString();
    }
}