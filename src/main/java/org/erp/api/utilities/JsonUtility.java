package org.erp.api.utilities;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

public class JsonUtility {
    public static JSONObject convertJSON (String json) throws JSONException {
        return new JSONObject(json);
    }


    public static String getValueFromJSON(String json,String propertyName) throws JSONException {
        String value= JsonUtility.convertJSON(json).get(propertyName).toString();
        return value;
    }

    public static boolean areEqualJSON(String expectedResult, String actualResult) throws JSONException {
        boolean isEqual=true;

        JSONObject jsonExpectedResult= JsonUtility.convertJSON(expectedResult);
        JSONObject jsonActualResult= JsonUtility.convertJSON(actualResult);

        Iterator<?> keys=jsonExpectedResult.keys();

        while (keys.hasNext()){
            String key = (String) keys.next();
            String actualValue=String.valueOf(jsonActualResult.get(key));
            String expectedValue=String.valueOf(jsonExpectedResult.get(key));

            if (expectedValue.equals("EXCLUDE")){
                System.out.println("INFO > EXCLUDE, the attribute ["+key+ "] no fue comparado");
            }else{
                if (!expectedValue.equals(actualValue)){
                    System.out.println("INFO > COMPARING, the attribute ["+key+ "]  actual value ["+actualValue+"] vs expected ["+expectedValue+"]");
                    isEqual=false;
                }
            }
        }
        return isEqual;
    }

}
