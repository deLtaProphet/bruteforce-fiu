package com.bruteforce.taxapplication.template;

import com.bruteforce.taxapplication.converter.JsonConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

public class TestString {

    public static void main(String[] args) {
        String json = "{\"header\":{\"rid\":\"7f87245d-7042-472f-b075-852ca56c01ef\",\"ts\":\"2020-07-30T19:15:38.775+0000\",\"channelId\":null},\"body\":[{\"fiObjects\":[\"<Account xmlns=\\\"http://api.rebit.org.in/FISchema/mutual_funds\\\" xmlns:xsi=\\\"http://www.w3.org/2001/XMLSchema-instance\\\" xsi:schemaLocation=\\\"http://api.rebit.org.in/FISchema/mutual_funds ../FISchema/mutual_funds.xsd\\\" linkedAccRef=\\\"03948856668855\\\" maskedAccNumber=\\\"03948856668855\\\" version=\\\"1.1\\\" type=\\\"mutualfunds\\\">\\n<Profile>\\n<Holders>\\n<Holder name=\\\"Onkar\\\" dob=\\\"1993-09-24\\\" mobile=\\\"9604839911\\\" nominee=\\\"NOT-REGISTERED\\\" dematId=\\\"\\\" email=\\\"onkar.gagare@gmail.com\\\" pan=\\\"AAAPL0234C\\\" ckycCompliance=\\\"true\\\"/>\\n</Holders>\\n</Profile>\\n<Summary investmentValue=\\\"10.0\\\" currentValue=\\\"20.0\\\">\\n<Investment>\\n<Holdings>\\n<Holding amc=\\\"Axis mutual funds\\\" registrar=\\\"M/s S R Batliboi & Co. (Mutual Fund) and and M/s Haribhakti & Co. (AMC)\\\" schemeCode=\\\"AFD1D\\\" isin=\\\"GB0002634946\\\" ucc=\\\"13345\\\" amfiCode=\\\"434345\\\" folioNo=\\\"4rwr4\\\" dividendType=\\\"shareholders\\\" mode=\\\"DEMAT\\\" FatcaStatus=\\\"YES\\\" units=\\\"6\\\" closingUnits=\\\"4\\\" lienUnits=\\\"3\\\" rate=\\\"12\\\" nav=\\\"funds\\\" lockingUnits=\\\"3\\\"/>\\n</Holdings>\\n</Investment>\\n</Summary>\\n<Transactions endDate=\\\"2019-07-24\\\" startDate=\\\"2020-07-24\\\">\\n<Transaction txnId=\\\"874247982749\\\" amc=\\\"44242\\\" registrar=\\\"t4t\\\" schemeCode=\\\"32244\\\" schemePlan=\\\"DIRECT\\\" schemeTypes=\\\"DEBT_SCHEMES\\\" schemeCategory=\\\"AGGRESSIVE_HYBRID_FUND\\\" isin=\\\"H6283489004\\\" amfiCode=\\\"45345\\\" schemeOption=\\\"REINVEST\\\" fundType=\\\"EQUITY\\\" ucc=\\\"\\\" amount=\\\"500000\\\" closingUnits=\\\"23\\\" lienUnits=3\\\"\\\" nav=\\\"funds\\\" navDate=\\\"2019-09-24\\\" type=\\\"BUY\\\" orderDate=\\\"2019-09-24\\\" executionDate=\\\"2019-09-24\\\" lock-inDays=\\\"3\\\" lock-inFlag=\\\"\\\" mode=\\\"DEMAT\\\" narration=\\\"buy\\\"/>\\n</Transactions>\\n</Account>\",{\"Profile\":{\"Holders\":{\"Holder\":{\"name\":\"Your Tech\",\"email\":\"yourname@email.com\",\"dob\":\"1992-09-24\",\"mobile\":\"9604839911\",\"ckycCompliance\":true,\"pan\":\"AAAPL1234C\",\"nominee\":\"NOT-REGISTERED\"},\"type\":\"SINGLE\"}},\"Summary\":{\"type\":\"CURRENT\",\"branch\":\"Pune\",\"facility\":\"CC\",\"ifscCode\":\"ICIC0000039\",\"micrCode\":\"411229003\",\"openingDate\":\"2017-01-01\",\"currentODLimit\":\"20000\",\"drawingLimit\":\"10000\",\"Pending\":{\"amount\":20.0},\"currentBalance\":\"271.19\",\"currency\":\"INR\",\"exchgeRate\":\"5.5\",\"balanceDateTime\":\"2020-07-12T18:20:00Z\",\"status\":\"ACTIVE\"},\"Transactions\":{\"Transaction\":[{\"type\":\"DEBIT\",\"mode\":\"OTHERS\",\"amount\":23.6,\"currentBalance\":\"4884.79\",\"transactionTimestamp\":\"2020-07-14T18:30:00Z\",\"valueDate\":\"2020-07-14\",\"txnId\":\"M391002303\",\"narration\":\"TO ATM TXN CHRGE 14 Jan 2020\",\"reference\":\"REF000246555\"},{\"type\":\"DEBIT\",\"mode\":\"OTHERS\",\"amount\":23.6,\"currentBalance\":\"4861.19\",\"transactionTimestamp\":\"2020-07-14T18:30:00Z\",\"valueDate\":\"2020-07-14\",\"txnId\":\"M391002304\",\"narration\":\"TO ATM TXN CHRGE 14 April 2020\",\"reference\":\"REF000246555\"},{\"type\":\"DEBIT\",\"mode\":\"OTHERS\",\"amount\":4500.0,\"currentBalance\":\"361.19\",\"transactionTimestamp\":\"2020-07-14T18:30:00Z\",\"valueDate\":\"2020-07-14\",\"txnId\":\"M391002305\",\"narration\":\"ATM CASH TXN/ICICI BANK LIMITED PUNE   KL\",\"reference\":\"REF000246555\"},{\"type\":\"CREDIT\",\"mode\":\"OTHERS\",\"amount\":460.0,\"currentBalance\":\"821.19\",\"transactionTimestamp\":\"2020-07-14T18:30:00Z\",\"valueDate\":\"2020-07-14\",\"txnId\":\"M391002306\",\"narration\":\"PC8027317       CFD ETRANSFER                     \",\"reference\":\"REF000246555\"},{\"type\":\"DEBIT\",\"mode\":\"OTHERS\",\"amount\":300.0,\"currentBalance\":\"521.19\",\"transactionTimestamp\":\"2020-07-15T18:30:00Z\",\"valueDate\":\"2020-07-15\",\"txnId\":\"M391002307\",\"narration\":\"MOBILE-RECHARGE/KBPUEHAFB5F3                     \",\"reference\":\"REF000246555\"},{\"type\":\"DEBIT\",\"mode\":\"OTHERS\",\"amount\":300.0,\"currentBalance\":\"521.19\",\"transactionTimestamp\":\"2020-07-15T18:30:00Z\",\"valueDate\":\"2020-07-15\",\"txnId\":\"M391002308\",\"narration\":\"MOBILE-RECHARGE/KBPUEHAFB5F3                     \",\"reference\":\"REF000246555\"},{\"type\":\"DEBIT\",\"mode\":\"OTHERS\",\"amount\":50.0,\"currentBalance\":\"471.19\",\"transactionTimestamp\":\"2020-07-10T18:30:00Z\",\"valueDate\":\"2020-07-10\",\"txnId\":\"M391002309\",\"narration\":\"MOBILE-RECHARGE/1NPY8S2D5TQL                     \",\"reference\":\"REF000246555\"},{\"type\":\"DEBIT\",\"mode\":\"OTHERS\",\"amount\":200.0,\"currentBalance\":\"271.19\",\"transactionTimestamp\":\"2020-07-10T18:30:00Z\",\"valueDate\":\"2020-07-10\",\"txnId\":\"M391002310\",\"narration\":\"MOBILE-RECHARGE/I2PWRQQYBLG3                     \",\"reference\":\"REF000246555\"}],\"startDate\":\"2020-01-30\",\"endDate\":\"2020-12-30\"},\"type\":\"deposit\",\"maskedAccNumber\":\"00012345\",\"linkedAccRef\":\"REF00012345\",\"version\":\"1.0\"},{\"Profile\":{\"Holders\":{\"Holder\":{\"name\":\"YOUR NAME\",\"email\":\"yourname@email.com\",\"dob\":\"1992-09-24\",\"mobile\":\"9999955555\",\"ckycCompliance\":true,\"pan\":\"CGDMP1444K\",\"nominee\":\"NOT-REGISTERED\"},\"type\":\"SINGLE\"}},\"Summary\":{\"type\":\"CURRENT\",\"branch\":\"Pune\",\"facility\":\"CC\",\"ifscCode\":\"BARB0SHIPOO\",\"micrCode\":\"411012011\",\"openingDate\":\"2018-01-01\",\"currentODLimit\":\"20000\",\"drawingLimit\":\"10000\",\"Pending\":{\"amount\":20.0},\"currentBalance\":\"4007.55\",\"currency\":\"INR\",\"exchgeRate\":\"5.5\",\"balanceDateTime\":\"2019-04-12T18:20:00Z\",\"status\":\"ACTIVE\"},\"Transactions\":{\"Transaction\":[],\"startDate\":\"2020-01-30\",\"endDate\":\"2020-12-30\"},\"type\":\"deposit\",\"maskedAccNumber\":\"00023459100\",\"linkedAccRef\":\"REF00023459100\",\"version\":\"1.0\"}],\"fipId\":\"BARB0KIMXXX\",\"fipName\":\"BARB0KIMXXX\",\"custId\":\"brutforce2@finvu\",\"consentId\":\"5f98f98a-c587-4309-8430-fe0549f309f9\",\"sessionId\":\"b61e7b3e-cbd8-4e56-9a67-29832acabd8f\"}]}\n";

        JSONObject jsonObject = new JSONObject(json);
        JSONArray jsonArray =  jsonObject.getJSONArray("body");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonConverter jsonConverter = new JsonConverter();
        jsonConverter.parseFipData(json);
//        for(Object jsonArray1:jsonArray){
//            JSONObject jsonObject1 = (JSONObject) jsonArray1;
//            String consentId = jsonObject1.getString("consentId");
//            String fipId = jsonObject1.getString("fipId");
//            JSONArray fipObjects = jsonObject1.getJSONArray("fiObjects");
//            for (Object fipObject : fipObjects) {
//                try {
//                    JSONObject jsonObject2 = (JSONObject) fipObject;
//
//                    System.out.println(jsonObject2);
//                    jsonConverter.parseJsonObject(jsonObject2);
//                } catch (Exception e){
//                    String fipJsonObject = (String) fipObject;
////                    System.out.println(fipJsonObject);
//                    jsonConverter.convertStringToXMLDocument(fipJsonObject);
//
//                }
//            }
//        }

        System.out.println(jsonConverter.getAmount());
        System.out.println(jsonConverter.getSchemtoDouble());
    }



}
