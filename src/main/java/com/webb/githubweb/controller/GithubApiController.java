package com.webb.githubweb.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.webb.githubweb.model.Commit;
import com.webb.githubweb.model.CommitResult;
import com.webb.githubweb.model.Repo;
import com.webb.githubweb.model.RepoResult;

@Controller
public class GithubApiController {
	static final String URL_GITHUB_SERACH = "https://api.github.com/search/repositories?q=";
	static final String URL_GITHUB_COMMITS = "https://api.github.com/repos/";
	
	// inject via application.properties
    @Value("${welcome.message}")
    private String message;


    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("message", message);
        model.addAttribute("item", new Repo());
        return "welcome"; //view
    }


    @RequestMapping(value = "/search", method = RequestMethod.GET,
     produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}) 
    public String searchRepository(@RequestParam(name ="name", required = true, defaultValue = "")  String name,Repo item,Model model) {
	    String url=URL_GITHUB_SERACH+name+"&per_page=100";
	    HttpEntity<CommitResult[]> entity = new HttpEntity<>(getHeaders());
	    RestTemplate restTemplate = new RestTemplate();
		// Send request with GET method, and Headers.
		ResponseEntity<RepoResult> response =restTemplate.exchange(url ,HttpMethod.GET, entity, RepoResult.class);
        model.addAttribute("items", response.getBody().getItems());
        model.addAttribute("total_count", response.getBody().getTotal_count());
    	return "/welcome"; //view
    }

    @RequestMapping(value = "/commits", method = RequestMethod.GET )
    public String listCommits(@RequestParam(name ="full_name", required = true, defaultValue = "")  String full_name,
    		                  @RequestParam(name ="chart", required = false, defaultValue = "developer")  String chart,Model model) {
    		    String url=URL_GITHUB_COMMITS+full_name+"/commits?per_page=100";
    		    RestTemplate restTemplate = new RestTemplate();
    		    ResponseEntity<List<CommitResult>> response = restTemplate.exchange(
    		     url,HttpMethod.GET,null,new ParameterizedTypeReference<List<CommitResult>>(){});
    		    List<CommitResult> commits = response.getBody();
    	        
    		    if("developer".equals(chart)) {
    		    	Map<String, Long> developerCommits=commits.stream().map(item -> item.getCommit()).collect(Collectors.groupingBy(Commit::getAuthorName, Collectors.counting()));
    		    	model.addAttribute("commiterCounting", developerCommits);
    		    }else if("timeline".equals(chart)){
    		    	Map<String, Long> timelineCommits=commits.stream().map(item -> item.getCommit()).collect(Collectors.groupingBy(Commit::getCommitDate, Collectors.counting()));
    		    	model.addAttribute("commiterCounting", timelineCommits);
    		    }else {
    		    	model.addAttribute("items", commits);
    		    	return "developerCommit";
    		    }
    	 return "developer".equals(chart)?"barGraph":"barGraph_timeLine"; 
   }
    
    public static <T> Predicate<T> distinctByKey(
    	    Function<? super T, ?> keyExtractor) {
    	   
    	    Map<Object, Boolean> seen = new ConcurrentHashMap<>(); 
    	    return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null; 
    	}
    
    @RequestMapping(value = "/users", method = RequestMethod.GET )
    public String listUsers(@RequestParam(name ="full_name", required = true, defaultValue = "")  String full_name,Model model) {
    	 	String url=URL_GITHUB_COMMITS+full_name+"/commits";
		    RestTemplate restTemplate = new RestTemplate();
		    ResponseEntity<List<CommitResult>> response = restTemplate.exchange(
		     url,HttpMethod.GET,null,new ParameterizedTypeReference<List<CommitResult>>(){});
		    List<CommitResult> commits = response.getBody();
		    List<CommitResult> result= commits.stream().filter(distinctByKey(p -> p.getAuthorName())).collect(Collectors.toList());
		    model.addAttribute("items",result);
		    return "developers"; 
   }


	private HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();	
		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON_UTF8}));
		//application/vnd.github.mercy-preview+json
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		return headers;
	}
    
    
	/*
	 * @GetMapping("/hello") public String mainWithParam(@RequestParam(name =
	 * "name", required = false, defaultValue = "") String name, Model model) {
	 * model.addAttribute("message", name); return "welcome"; //view }
	 */
    
	
}
