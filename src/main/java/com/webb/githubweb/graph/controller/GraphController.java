package com.webb.githubweb.graph.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GraphController {

	@GetMapping("/displayBarGraph")
	public String barGraph(Model model) {
		/*
		 * Map<String, Integer> surveyMap = new LinkedHashMap<>(); surveyMap.put("Java",
		 * 40); surveyMap.put("Dev oops", 25); surveyMap.put("Python", 20);
		 * surveyMap.put(".Net", 15);
		 */
		model.addAttribute("surveyMap", model.asMap().get("CommiterCounting"));
		return "barGraph";
	}

	@GetMapping("/displayPieChart")
	public String pieChart(Model model) {
		model.addAttribute("pass", 50);
		model.addAttribute("fail", 50);
		return "pieChart";
	}

}
