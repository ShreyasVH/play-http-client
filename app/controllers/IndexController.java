package controllers;

import com.google.inject.Inject;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Http;
import play.mvc.Results;
import services.ApiService;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.CompletionStage;

public class IndexController extends Controller
{
	private final ApiService apiService;

	@Inject
	public IndexController(ApiService apiService)
	{
		this.apiService = apiService;
	}

	public CompletionStage<Result> get()
	{
		return apiService.get("https://cors/playframework.com/api?input=abc", Map.of("c", Arrays.asList("d"))).thenApply(Results::ok);
	}

	public CompletionStage<Result> post()
	{
		return apiService.post("https://cors/playframework.com/api", Map.of("a", "A", "b", "B"), Map.of("c", Arrays.asList("d"))).thenApply(Results::ok);
	}

	public CompletionStage<Result> put()
	{
		return apiService.put("https://cors/playframework.com/api", Map.of("a", "A", "b", "B"), Map.of("c", Arrays.asList("d"))).thenApply(Results::ok);
	}

	public CompletionStage<Result> delete()
	{
		return apiService.delete("https://cors/playframework.com/api", Map.of("c", Arrays.asList("d"))).thenApply(Results::ok);
	}
}