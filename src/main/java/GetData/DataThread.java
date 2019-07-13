package GetData;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class DataThread implements Runnable{
    String tempRead=null;
    StringBuffer resultBuffer=new StringBuffer();

    public void run() {
        String str="https://kyfw.12306.cn/otn/leftTicket/submitOrderRequest";//提交预定表单
        //String srr1="https://kyfw.12306.cn/otn/confirmPassenger/getPassengerDTOs"://获取乘客信息
        //String str="https://kyfw.12306.cn/otn/confirmPassenger/queryOrderWaitTime";
        //String str="https://kyfw.12306.cn/otn/leftTicket/query?leftTicketDTO.train_date=2019-5-04&leftTicketDTO.from_station=SHH&leftTicketDTO.to_station=BJP&purpose_codes=ADULT";
        //String str="https://kyfw.12306.cn/otn/leftTicket/query?leftTicketDTO.train_date=2019-05-04&leftTicketDTO.from_station=SHH&leftTicketDTO.to_station=BJP&purpose_codes=ADULT";
         try {
             URL url=new URL(str);
             HttpURLConnection connection=(HttpURLConnection)url.openConnection();
             connection.setRequestMethod("POST");
             connection.setConnectTimeout(5000);

             connection.setDoOutput(true);
             Map<String,String> formdata=new HashMap<String, String>();
             formdata.put("secretStr:","zSrxtmN0op/FbuEYKNBesUXE5FSQyfFxga55k0nr618AcHS1iOp8V3lwRgLL12pbbjZl+KsCwcle\n" +
                     "QwdnaS2Ca/WYYUjLWlAAfWAZmQhFSHPMjeRhbkq33+jM7y93F81r2A/tTaq9aqbDEAZiqwaWyyux\n" +
                     "K+C4HrTYwTi/hFa8YAHw+63+7UWk3LHd0HVpRsolDHHNKPKJyEOe9GAjoAXO3YczvlSkaQo0dJBU\n" +
                     "9bOcDseqG3kq+pAuspelMK593qHlMbl9QjnihfiiSX1HWc8e2okuvwisu+LaJrJ4XkmT81NIoYy1\n" +
                     "Xgmjrvzg6WbMkDKZ");
             formdata.put("train_date:","2019-05-04");
             formdata.put("back_train_date:","2019-05-04");
             formdata.put("tour_flag:","dc");
             formdata.put("purpose_codes:","ADULT");
             formdata.put("query_from_station_name:","杭州东");
             formdata.put("query_to_station_name:","上海");
             formdata.put("undefined: ","");
             //connection.getOutputStream().write(formdata.toString().getBytes());// 输入参数

             InputStream inStream=connection.getInputStream();
             BufferedReader reader=new BufferedReader(new InputStreamReader(inStream));

             while((tempRead=reader.readLine())!=null){
                 resultBuffer.append(tempRead);
             }
         }catch (Exception e){
             e.printStackTrace();
         }
         JsonAnalysis ja=new JsonAnalysis();
         //ja.readJson(resultBuffer.toString());
         System.out.println(resultBuffer.toString());
    }
    public void jsonAnalysis(){

    }
}
