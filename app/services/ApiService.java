package services;

import com.google.inject.Inject;
import play.libs.ws.*;
import play.libs.ws.ahc.AhcCurlRequestLogger;
import utils.Utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletionStage;

public class ApiService implements WSBodyReadables, WSBodyWritables
{
    private final WSClient wsClient;

    @Inject
    public ApiService(WSClient wsClient)
    {
        this.wsClient = wsClient;
    }

    public CompletionStage<String> get(String url, Map<String, List<String>> additionalHeaders)
    {
        return wsClient.url(url).setHeaders(additionalHeaders).get().thenApply(WSResponse::getBody);
    }

    public CompletionStage<String> post(String url, Object payload, Map<String, List<String>> additionalHeaders)
    {
        Map<String, List<String>> headers = new HashMap<>(){
            {
                put("Content-Type", Collections.singletonList("application/json"));
            }
        };
        headers.putAll(additionalHeaders);

        return wsClient.url(url).setHeaders(headers).post(Utils.toJson(payload)).thenApply(WSResponse::getBody);
    }

    public CompletionStage<String> put(String url, Object payload, Map<String, List<String>> additionalHeaders)
    {
        Map<String, List<String>> headers = new HashMap<>(){
            {
                put("Content-Type", Collections.singletonList("application/json"));
            }
        };
        headers.putAll(additionalHeaders);

        return wsClient.url(url).setHeaders(headers).put(Utils.toJson(payload)).thenApply(WSResponse::getBody);
    }

    public CompletionStage<String> delete(String url, Map<String, List<String>> additionalHeaders)
    {
        return wsClient.url(url).setHeaders(additionalHeaders).delete().thenApply(WSResponse::getBody);
    }
}
