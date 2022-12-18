package ds.circuit.breaker.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

@Service

public class PingService {

	private OkHttpClient okHttpClient;

	public PingService() {

		okHttpClient = new OkHttpClient();

	}

	@HystrixCommand(fallbackMethod = "pingFallback")
	public String pingGoogle() throws IOException {

		final Request request = new Request.Builder()
													.url("https://google.com/")
													.get()
													.addHeader("cache-control", "no-cache")
													.build();
													okHttpClient.newCall(request).execute();

		return "Ping to Google was successful!";

	}

	private String pingFallback() {
		return "Resource is busy or offline";
	}

}
