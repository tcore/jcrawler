package jcrawler.service.fetcher;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.net.URISyntaxException;

@Service
public class FetcherImpl implements FetcherInterface {
    @Override
    public FetcherResponse fetch(FetcherRequest request) throws IOException, URISyntaxException {
        return get(request);
    }

    protected FetcherResponse get(FetcherRequest request) throws URISyntaxException, IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet get = new HttpGet(request.getUri());
        CloseableHttpResponse response = httpClient.execute(get);
        try {
            FetcherResponse fetcherResponse = new FetcherResponse();
            HttpEntity entity = response.getEntity();
            if (entity == null) {
                fetcherResponse.setContent("");

                return fetcherResponse;
            }
            fetcherResponse.setContent(IOUtils.toString(entity.getContent()));

            return fetcherResponse;
        } finally {
            EntityUtils.consume(response.getEntity());
            response.close();
            httpClient.close();
        }
    }
}
