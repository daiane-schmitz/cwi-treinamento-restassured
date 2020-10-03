package br.com.restassuredapitesting.utils;

import org.json.simple.JSONObject;

public class Utils {

    public static JSONObject validPayloadBooking(){
         JSONObject payload = new JSONObject();
         JSONObject bookingDates = new JSONObject();

         bookingDates.put("checkin", "2018-01-01");
         bookingDates.put("checkout", "2019-01-01");

         payload.put("firstname","Ronaldo");
         payload.put("lastname", "Fenomeno");
         payload.put("totalprice", 111);
         payload.put("depositpaid", true);
         payload.put("bookingdates", bookingDates);
         payload.put("additionalneeds", "Breakfast");

         return payload;
    }

    public static JSONObject invalidPayloadBooking() {
        JSONObject payload = new JSONObject();

        payload.put("cidade","Porto Alegre");
        payload.put("estado", "Rio Grande do Sul");
        payload.put("País", "Brasil");
        return payload;
    }

    public static JSONObject payloadBooking(){
        JSONObject payload = new JSONObject();
        JSONObject bookingDates = new JSONObject();

        bookingDates.put("checkin", "2018-01-01");
        bookingDates.put("checkout", "2019-01-01");

        payload.put("firstname","Ronaldo");
        payload.put("lastname", "Fenomeno");
        payload.put("totalprice", 111);
        payload.put("depositpaid", true);
        payload.put("bookingdates", bookingDates);
        payload.put("additionalneeds", "Breakfast");
        payload.put("discount", 20);

        return payload;
    }

    public static String getContractsBasePath(String pack, String contract) {
        return System.getProperty("user.dir")
                + "/src/test/java/br/com/restassuredapitesting/tests/"
                + pack
                + "/contracts/"
                + contract
                + ".json";
    }



}
