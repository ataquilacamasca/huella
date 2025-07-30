package com.fingerprint;

//import com.touchlessid.TouchLessIDSDK;

import android.content.Context;
import android.util.Log;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class FingerprintPlugin extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        Log.i("FingerprintPlugin", "Ejecutando acción: " + action);
        if ("autenticar".equals(action)) {
            autenticar(callbackContext);
            return true;
        }
        return false;
    }

    private void autenticar(CallbackContext callbackContext) {
        Context context = this.cordova.getActivity().getApplicationContext();
        try {
            Log.i("FingerprintPlugin", "Iniciando TouchLessIDSDK...");
            TouchLessIDSDK sdk = new TouchLessIDSDK(); // Instancia del SDK

            JSONObject result = new JSONObject();
            result.put("wsq", "simuladoWSQbase64==");
            result.put("hand", "derecha");
            result.put("img", "simuladoBase64Imagen==");

            Log.i("FingerprintPlugin", "Resultado generado: " + result.toString());
            callbackContext.success(result);
        } catch (Exception e) {
            Log.e("FingerprintPlugin", "Error: " + e.getMessage(), e);
            callbackContext.error("Error al iniciar el SDK: " + e.getMessage());
        }
    }
}
