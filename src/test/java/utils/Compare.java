package utils;

import java.util.Objects;
import java.util.Set;

public class Compare {
    public static boolean check(DataProperties a, ExcelModel b) {
        boolean status = false;
        String[] values_a_keynames = {"Customer Name", "Customer ID", "Address", "Phone Number"};
        String[] values_b = new String[0];
        if (b.list().contains(a.getValueOf("Customer ID"))) {
            //System.out.println("------> value : "+a.getValueOf("Customer ID"));
            for (int i = 0; i < (b.listSize()); i++) {
                if (b.getValue(i).contains(a.getValueOf("Customer ID"))) {
                    values_b = b.getValue(i).split(",");
                    break;
                }
            }

            for (int i = 0; i < values_b.length; i++) {
                //System.out.println("a:\t"+a.getValueOf(values_a_keynames[i])+"\tb:\t"+values_b[i]);
                if (a.getValueOf(values_a_keynames[i]).equalsIgnoreCase(values_b[i]))
                    status = true;
                else{
                    status = false;
                    break;
                }

            }

        }
        return status;
    }
}
