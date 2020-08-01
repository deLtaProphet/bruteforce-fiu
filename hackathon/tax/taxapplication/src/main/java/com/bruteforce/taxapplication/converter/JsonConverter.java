package com.bruteforce.taxapplication.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JsonConverter {
    private Double amount;
    private Map<String,String> schemeToAmount;

    public Map<String, Double> getSchemtoDouble() {
        return schemtoDouble;
    }

    private Map<String,Double> schemtoDouble;


    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Map<String, String> getSchemeToAmount() {
        return schemeToAmount;
    }

    public void setSchemeToAmount(Map<String, String> schemeToAmount) {
        this.schemeToAmount = schemeToAmount;
    }

    public JsonConverter(){
        this.amount = 0.0;
        this.schemeToAmount = new HashMap<>();
        this.schemtoDouble = new HashMap<>();
    }

    public void parseFipData(String data){

        JSONObject jsonObject = new JSONObject(data);
        JSONArray jsonArray =  jsonObject.getJSONArray("body");
        ObjectMapper objectMapper = new ObjectMapper();
        for(Object jsonArray1:jsonArray){
            JSONObject jsonObject1 = (JSONObject) jsonArray1;
            String consentId = jsonObject1.getString("consentId");
            String fipId = jsonObject1.getString("fipId");
            JSONArray fipObjects = jsonObject1.getJSONArray("fiObjects");
            for (Object fipObject : fipObjects) {
                try {
                    JSONObject jsonObject2 = (JSONObject) fipObject;
                    System.out.println(jsonObject2);
                    this.parseJsonObject(jsonObject2);
                } catch (Exception e){
                    String fipJsonObject = (String) fipObject;
//                    System.out.println(fipJsonObject);
                    this.convertStringToXMLDocument(fipJsonObject);

                }
            }
        }
    }

    private void parseJsonObject(JSONObject jsonObject) {
      Iterator<String> str =  jsonObject.keys();
      while (str.hasNext()){
          String keyVal = str.next();
          switch (keyVal){
              case "Transactions":
                  JSONObject jsonObject1 = (JSONObject) jsonObject.get("Transactions");
                  JSONArray jsonArray = jsonObject1.getJSONArray("Transaction");
                  for (Object o : jsonArray) {
                      JSONObject transactionDetails = (JSONObject) o;
                      Double amount = transactionDetails.getDouble("amount");
                      String type = transactionDetails.getString("type");
                      Double am = this.schemtoDouble.getOrDefault(type,0.0);
                      am = am + amount;
                      this.schemtoDouble.put(type,am);
                  }
              case "":
                  System.out.println();
          }
      }
    }
    private void convertStringToXMLDocument(String xmlString)  {
        Map<String,String>  mp = new HashMap<>();
        String[] arr = xmlString.split("<");
        for (String s : arr) {
            if(s.contains("Transaction") && s.contains("txnId")){
                String[] keyVal = s.split(" ");
                String amount = "";
                String type="";
                for (String s1 : keyVal) {
                    String[] ahs = s1.split("=");
                    String lhs = ahs[0];
                    if(lhs.equals("amount")){
                        amount = ahs[1];

                    } else if(lhs.equals("mode")){
                        type= ahs[1];
                    }
                }
                if(!amount.isEmpty()){
                    if(amount.contains("\"")){
                        Double am = Double.valueOf(amount.substring(1,amount.length()-1));
                        this.schemtoDouble.put("MF",am);
                    } else {
                        Double am = Double.valueOf(amount);
                        this.schemtoDouble.put("MF",am);
                    }
                }
            }
        }
    }


}
