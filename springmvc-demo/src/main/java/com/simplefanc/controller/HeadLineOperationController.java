package com.simplefanc.controller;


import com.simplefanc.entity.bo.HeadLine;
import com.simplefanc.entity.dto.Result;
import com.simplefanc.service.HeadLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "headline")
public class HeadLineOperationController {
	@Autowired
	private HeadLineService headLineService;

	/**
	 * 添加
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView addHeadLine(@RequestParam("lineName") String lineName,
									@RequestParam("lineLink") String lineLink,
									@RequestParam("lineImg") String lineImg,
									@RequestParam("priority") Integer priority) {
		HeadLine headLine = new HeadLine();
		headLine.setLineName(lineName);
		headLine.setLineImg(lineImg);
		headLine.setLineLink(lineLink);
		headLine.setPriority(priority);
		Result<Boolean> result = headLineService.addHeadLine(headLine);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("addHeadline");
		modelAndView.addObject("result", result);
		return modelAndView;
	}

	/**
	 * http://localhost:8080/springframework/headline/open
	 * @return
	 */
	@RequestMapping(value = "/open", method = RequestMethod.GET)
	public String openPage() {
		return "addHeadline";
	}
}
