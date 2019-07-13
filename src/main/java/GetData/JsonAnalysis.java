package GetData;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.Arrays;
import java.util.Vector;

public class JsonAnalysis {
    Vector dataList;
    String[] dataStr;
    JsonAnalysis(){
        dataList=new Vector();
    }
    public void readJson(String str){
        JSONObject json=JSONObject.fromObject(str);
        JSONObject data=json.getJSONObject("data");
        JSONArray result=data.getJSONArray("result");

        for (int i=0,len=result.size();i<len;i++){
            dataStr=new String[100];
            dataStr=result.get(i).toString().split("\\|");
            //System.out.println(result.get(i).toString().split("|").);
            dataList.add(Arrays.asList(dataStr));

            //System.out.println(dataStr[2]);
        }
        for(int j=0,len=dataList.size();j<len;j++)
        System.out.println(dataList.get(j).toString().split("\\,")[2]);
    }
}
