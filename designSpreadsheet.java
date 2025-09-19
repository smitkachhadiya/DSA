import java.util.HashMap;

//  3484. Design Spreadsheet

class Spreadsheet {
    HashMap<String,Integer> map = new HashMap<>();

    public Spreadsheet(int rows) {
    }

    public void setCell(String cell, int value) {
        map.put(cell , value);
    }

    public void resetCell(String cell) {
        map.put(cell,0);
    }

    public int getValue(String formula) {
        formula = formula.substring(1);
        for (int i = 0; i < formula.length(); i++) {
            if(formula.charAt(i) == '+'){
                String s1 = formula.substring(0,i);
                String s2 = formula.substring(i+1);
                int left = Character.isUpperCase(s1.charAt(0)) ? map.getOrDefault(s1,0) : Integer.parseInt(s1);
                int right = Character.isUpperCase(s2.charAt(0)) ? map.getOrDefault(s2,0) : Integer.parseInt(s2);
                return left + right;
            }
        }
        return 0;
    }
}

public class designSpreadsheet {

    public static void main(String[] args) {
        Spreadsheet ss = new Spreadsheet(10);
        System.out.println(ss.getValue("=5+7"));;
        ss.setCell("A1",10);
        System.out.println(ss.getValue("=A1+6"));;
        ss.setCell("B2",15);
        System.out.println(ss.getValue("=A1+B2"));
        ss.resetCell("A1");
        System.out.println(ss.getValue("=A1+B2"));;
    }
}