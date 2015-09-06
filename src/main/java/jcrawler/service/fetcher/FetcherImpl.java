package jcrawler.service.fetcher;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;

public class FetcherImpl implements FetcherInterface {
    @Override
    public FetcherResponse fetch(FetcherRequest request) throws IOException, URISyntaxException {
        return get(request);
    }

    protected FetcherResponse get(FetcherRequest request) throws URISyntaxException, IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet get = new HttpGet(request.getUri());
        CloseableHttpResponse response = httpClient.execute(get);

        FetcherResponse fetcherResponse = new FetcherResponse();
        HttpEntity entity = response.getEntity();
        fetcherResponse.setContent(IOUtils.toString(entity.getContent()));
        EntityUtils.consume(entity);

        response.close();
        httpClient.close();

        return fetcherResponse;
    }
}
