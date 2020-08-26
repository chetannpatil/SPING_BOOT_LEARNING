package com.JsonRespForWhiteLabelErro.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.JsonRespForWhiteLabelErro.model.ErrorJson;

@RestController
public class CustomErrorController implements ErrorController
{

	private static final String PATH="/error";
	
	@Value("${debug}")
	private boolean debug ;
	
	@Autowired
	private ErrorAttributes errorAttributes ;
	
	
	@Override
	public String getErrorPath()
	{
		return PATH;
	}

	//public ErrorJson getErrorMessage(HttpServletRequest request,HttpServletResponse response)
	@GetMapping(value = PATH)
	public ErrorJson getErrorMessage(WebRequest webRequest,HttpServletResponse response)
	{
		System.out.println("CustomErrorController getErrorMessage\n");
		
		return new ErrorJson(response.getStatus(),getAttributes(debug,webRequest));
	}

	private Map<String, Object> getAttributes(boolean includeStackTrace, WebRequest webRequest) 
	{
		System.out.println("CustomErrorController getAttributes\n");
		
		//WebRequest requestAttributes = (WebRequest)new ServletRequestAttributes(webRequest);
		//WebRequest web = new W
		//RequestAttribute requestAttributes = new ServletRequestAttributes(request);
	//	return errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace);
		
		return errorAttributes.getErrorAttributes(webRequest, includeStackTrace);
		
	}
}
