package io.github.payrexx.taptopay.sdk.lib.operation;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.github.payrexx.taptopay.sdk.dto.Dto;
import io.github.payrexx.taptopay.sdk.lib.helper.TapToPayFragment;
import io.github.payrexx.taptopay.sdk.lib.helper.TapToPayResultListener;
import io.github.payrexx.taptopay.sdk.model.ListResponse;
import io.github.payrexx.taptopay.sdk.model.SingleResponse;

/**
 * An abstract class representing a Tap to Pay operation.
 * This class is not intended to be used directly by developers.
 * @hide
 */
public abstract class Operation {

    protected final Dto dto;

    protected Operation(Dto dto) {
        this.dto = dto;
    }

    /**
     * Starts the operation.
     *
     * @param taptopayFragment The fragment to use for the operation.
     * @param taptopayResultListener The listener to be notified of the result.
     */
    public abstract void startOperation(TapToPayFragment taptopayFragment, TapToPayResultListener taptopayResultListener);

    protected JsonObject getRequestData() {
        return this.getRequestData(null);
    }

    protected JsonObject getRequestData(String operation) {
        Gson gson = new Gson();

        JsonObject data = new JsonObject();
        data.add("data", gson.toJsonTree(dto).getAsJsonObject());
        if (operation != null) {
            data.addProperty("operation", operation);
        }

        JsonObject request = new JsonObject();
        request.addProperty("payload", data.toString());
        request.addProperty("signature", "");
        return request.getAsJsonObject();
    }

    protected SingleResponse parseResponseData(String jsonData) {
        JsonObject resultObject = JsonParser.parseString(jsonData).getAsJsonObject();
        String payloadStr = resultObject.get("payload").getAsString();

        JsonObject payload = JsonParser.parseString(payloadStr).getAsJsonObject();
        JsonElement responseBodyEl = payload.get("responseBody");
        JsonObject responseBody;
        if (responseBodyEl.isJsonPrimitive()) {
            String message = responseBodyEl.getAsString();
            responseBody = new JsonObject();
            responseBody.addProperty("message", message);
        } else {
            responseBody = responseBodyEl.getAsJsonObject();
        }

        Gson gson = new Gson();
        return gson.fromJson(responseBody, SingleResponse.class);
    }

    protected ListResponse parseResponseListData(String jsonData) {
        JsonObject resultObject = JsonParser.parseString(jsonData).getAsJsonObject();
        String payloadStr = resultObject.get("payload").getAsString();

        JsonObject payload = JsonParser.parseString(payloadStr).getAsJsonObject();
        JsonObject responseBody = payload.get("responseBody").getAsJsonObject();

        Gson gson = new Gson();
        return gson.fromJson(responseBody, ListResponse.class);
    }
}
