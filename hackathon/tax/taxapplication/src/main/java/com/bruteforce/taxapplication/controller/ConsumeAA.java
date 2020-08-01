package com.bruteforce.taxapplication.controller;


import com.bruteforce.taxapplication.converter.JsonConverter;
import com.bruteforce.taxapplication.model.ConsentRequest;
import com.bruteforce.taxapplication.model.DataFormat;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public  class ConsumeAA {

    public static final String  CONSENT_STATUS = "CONSENT_STATUS";
    public static final String  DATA_STATUS = "DATA_STATUS";

    private static final Logger logger = LoggerFactory.getLogger(ConsumeAA.class);

    private static String uri = "https://finsense.finvu.in/ConnectHub/FIU/API/V1/SubmitConsentRequest";

    private static String checkStatusUri = "https://finsense.finvu.in/ConnectHub/FIU/API/V1/ConsentStatus/%s/bruteforce@finvu.in?";

    private static String fiDataReq = "https://finsense.finvu.in/ConnectHub/FIU/API/V1/FIRequest?";

    private static String fidataCheckStatus = "https://finsense.finvu.in/ConnectHub/FIU/API/V1/FIStatus/%s/%s/%s/%s";

    private static String fidataFetch = "https://finsense.finvu.in/ConnectHub/FIU/API/V1/FIFetch/%s/%s/%s";

    public Map<String, Double> getSchmeToAmountMap() {
        return schmeToAmountMap;
    }

    public void setSchmeToAmountMap(Map<String, Double> schmeToAmountMap) {
        this.schmeToAmountMap = schmeToAmountMap;
    }

    private Map<String,Double> schmeToAmountMap;


    private Map<String, String> headerBodyMap;
    private String customerId;

    public String getBearer() {
        return bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    private String bearer;

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }

    private String sessionId;

    public String getConsentId() {
        return consentId;
    }

    public void setConsentId(String consentId) {
        this.consentId = consentId;
    }

    private String consentId;

    public void setConsentHandleId(String consentHandleId) {
        this.consentHandleId = consentHandleId;
    }

    public String getConsentHandleId() {
        return consentHandleId;
    }

    private String consentHandleId;

    public void setHeaders(HttpHeaders headers) {
        this.headers = headers;
    }

    private HttpHeaders headers;

    public ConsumeAA(String customerId){
        this.customerId = customerId;
    }

    private String getRequestUrl(String RequestType){
        switch (RequestType){
            case CONSENT_STATUS:
                return String.format(checkStatusUri,this.getConsentHandleId());
            case DATA_STATUS:
                return String.format(fidataCheckStatus,this.getConsentId(),this.getSessionId()
                ,this.getConsentHandleId(),this.customerId);
            default:
                System.out.println("Not matching any data request");
                return "";
        }
    }

//    public static void main(String[] args) {
//        ConsumeAA consumeAA = new ConsumeAA("brutforce2@finvu");
//        consumeAA.consentReq();
//
//    }

    public void consentReq() {
        /*TODO
         Bring Bearer from user id
         */
        String Bearer = "Bearer: eyJraWQiOiJyc2ExIiwiYWxnIjoiUlMyNTYifQ.eyJpc3MiOiJjb29raWVqYXIiLCJhdWQiOiJjb29raWVqYXIiLCJleHAiOjIwNjIzMjEzMDEsImp0aSI6InZuTVVUeTFCZmd0eGxoalppUnU0WnciLCJpYXQiOjE1OTU3NjEzMDEsIm5iZiI6MTU5NTc2MTMwMSwic3ViIjoidXNlcjJfYnJ1dGZvcmNlIiwicm9sIjoiZGV2ZWxvcGVyIn0.SEeJOBxx44kbhoev0vLIZhKfhKJwWJIlIcBHWqYOzhsLLgdc6jL2-aOXa2pl4mvvTiC2e6lTxrMu8EpmxCNJkfTw3qYdlwzMlihTopgMQeJ1vpC3zp61fWP9cfcUYa-TFR9pzopU_HS-zKo-LTBnf-GCh23ulUjZlnT0B3Sb4Q9oyFNhfexJvV2jQfDZLQbosveH7LkePtu1r7Fudfgy5k5FKyjfLzRyCq2lvfVW-A2SH6xkk7yCA_ZwWKteDrC_OsGI2zI7R6bRUivOGp_bXc5_zR754_56zwoRqHEiq_lTKmfj4p5dvxxz4JrXPf2eDHXxcZ3jlDeeiVmdKRS3-Q";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        this.setBearer(Bearer);
        headers.setBearerAuth(this.getBearer());
        headers.set("channelId","finsense");
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> header = new HashMap<>();
        Map<String, Object> body = new HashMap<>();
        body.put("custId", this.customerId);
        body.put("consentDescription", "Template Test for development BrutForce");
        body.put("templateName", "basic template");
        header.put("rid", "f871126b-dd3f-4bb4-be8c-b1911b57a893");
        header.put("ts", "2020-07-26T12:58:33.501+0000");
        header.put("channelId", null);
        map.put("header",header);
        map.put("body",body);
//
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);
//
//            // send POST request
        ResponseEntity<ConsentRequest> response = restTemplate.postForEntity(uri, entity, ConsentRequest.class);

        if(response.getStatusCode().equals(HttpStatus.OK)){
            this.setHeaders(headers);
//            System.out.println(response.getBody().body);
//            System.out.println(response.getBody().errors);

            Map<String, String> mp = response.getBody().body;
            System.out.println(mp);
            System.out.println(response.getBody());
            String consentHandle  = mp.get("consentHandle");
            System.out.println("consent Handle is "+consentHandle);
            this.setConsentHandleId(consentHandle);
            boolean status = this.checkStatus(CONSENT_STATUS);
            if(status == true){
                System.out.println("consent Accepted ");
                boolean dataStatus = this.fIDataRequest();
                if(dataStatus == true){
                    System.out.println("polling data for ready state ");
                    boolean dataStatus1 = this.checkStatus(DATA_STATUS);
                    if(dataStatus1){
                        System.out.println("Fetching ");
                        this.fIDataFetch();
                    }
                }
            }
            System.out.println(status);
        } else {
            System.out.println("bad url "+response.getStatusCode());
        }


    }

    private boolean checkStatus(String statusType) {
        try {
            boolean flag = true;
            String checkStausUri = getRequestUrl(statusType);
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers1 = new HttpHeaders();
            headers1.setBearerAuth(this.getBearer());
            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(headers1);

            while (flag){

                ResponseEntity<ConsentRequest> response = restTemplate.exchange(
                        checkStausUri,
                        HttpMethod.GET,
                        entity,
                        ConsentRequest.class,
                        1
                );

                if(response.getStatusCode().equals(HttpStatus.OK)) {

                    if(statusType.equals(CONSENT_STATUS)){
                        String status = response.getBody().body.get("consentStatus");

                        if(status.equals("ACCEPTED")){
                            String consentId = response.getBody().body.get("consentId");
                            System.out.println(consentId);
                            this.setConsentId(consentId);
                            return true;
                        }
                        System.out.println(response.getBody());
                    } else {
                        System.out.println("waiting for get data to ready state ");

                        String status = response.getBody().body.get("fiRequestStatus");

                        if(status.equals("READY")){
//                            String consentId = response.getBody().body.get("consentId");
//                            System.out.println(consentId);
//                            this.setConsentId(consentId);
                            return true;
                        }
                        System.out.println(response.getBody());

                    }
                }

                Thread.sleep(5000);

            }
            return flag;

        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    private boolean fIDataRequest() {
        try {
            String fidataUri1 = fiDataReq;
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(this.getBearer());
            headers.set("rid","723d8822-0cc9-4944-a31c-53b954f2616e");
            headers.set("ts","2020-01-13T12:58:33.501+0000");
            Map<String, Object> map = new HashMap<>();
            Map<String, Object> header = new HashMap<>();
            Map<String, Object> body = new HashMap<>();

            header.put("rid", "723d8822-0cc9-4944-a31c-53b954f2616e");
            header.put("ts", "2020-07-26T14:42:51.901+0000");
            body.put("custId", this.customerId);
            body.put("consentId",this.consentId);
            body.put("consentHandleId",this.consentHandleId);
            body.put("dateTimeRangeFrom","2020-01-30T08:10:45.006");
            body.put("dateTimeRangeTo","2020-12-30T08:10:45.006");
            map.put("header",header);
            map.put("body",body);

            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

            ResponseEntity<ConsentRequest> response = restTemplate.postForEntity(fidataUri1, entity, ConsentRequest.class);

            if(response.getStatusCode().equals(HttpStatus.OK)){
                Map<String, String> mp = response.getBody().body;
                String seesionId = mp.get("sessionId");
                System.out.println("session id is"+seesionId);
                this.setSessionId(seesionId);
                return true;
            } else {
                System.out.println("bad url "+response.getStatusCode());
                return false;
            }


        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    private void fIDataFetch() {
        try {
            String fecthUrl = String.format(fidataFetch,this.customerId,this.consentId,this.sessionId);
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(this.getBearer());
            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(headers);
            ResponseEntity<String> response = restTemplate.exchange(
                    fecthUrl,
                    HttpMethod.GET,
                    entity,
                    String.class,
                    1
            );
            if(response.getStatusCode().equals(HttpStatus.OK)) {
                System.out.println(response.getBody());
                JsonConverter jsonConverter = new JsonConverter();
                jsonConverter.parseFipData(response.getBody());
                this.setSchmeToAmountMap(jsonConverter.getSchemtoDouble());
                System.out.println(jsonConverter.getSchemeToAmount());
            }
            }catch (Exception e){
            e.printStackTrace();
        }

    }

}