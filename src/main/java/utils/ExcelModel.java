package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExcelModel {
    private String customer_name;
    private String customer_id;
    private String customer_address;
    private String customer_phoneNum;
    private String sectionName;
    private final List<String> content_list;
    //private Map<String, String> contents = new HashMap<>();

    // Constructor
//    public ExcelModel(String name, String id, String add, String num) {
//        this.customer_name = name;
//        this.customer_id = id;
//        this.customer_address = add;
//        this.customer_phoneNum = num;
//    }

    // Constructor 2
    public ExcelModel(List<String> content) {
        this.content_list = content;
    }

    // --- Display
    public void Display() {
        System.out.println(this.content_list);
    }

    public String list(){
        return content_list.toString();
    }
    public int listSize(){
        return content_list.size();
    }

    public String getValue(int index){
        return content_list.get(index);
    }

}
