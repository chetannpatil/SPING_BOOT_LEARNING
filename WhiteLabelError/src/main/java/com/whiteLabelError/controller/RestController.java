package com.whiteLabelError.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import com.whiteLabelError.model.ErrorJson;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "/white")
public class RestController implements ErrorController
{

	//has a
	private int x = (-1>>>1);
	
	private Map<String, Integer>  idiotsMap = new HashMap<String, Integer>();
	
	//I.I
	{
		System.out.println("\n I.I x = \n"+x);
		System.out.println("I I idiotsMap = "+idiotsMap);
		for(Entry e : idiotsMap.entrySet())
		{
			System.out.println(" I I e.getKey() = "+e.getKey());
			System.out.println(" I I e.getValue() = "+e.getValue());
		}
	}
	
	static
	{
		System.out.println("\n static .I \n");
	
	}
	
	
	public RestController(int x, boolean debug, ErrorAttributes errorAttributes)
	{
		super();
		System.out.println("\n constructor with x =\n"+x+
				" debug = "+debug+" erroratrbure = \n "+errorAttributes);

		System.out.println("idiotsMap = "+idiotsMap);
		for(Entry e : idiotsMap.entrySet())
		{
			System.out.println(" I I e.getKey() = "+e.getKey());
			System.out.println(" I I e.getValue() = "+e.getValue());
		}
		
		this.x = x;
		this.debug = debug;
		this.errorAttributes = errorAttributes;
	}

	public RestController() {
		super();
		System.out.println("\n no arg constructor x = \n"+x);
		
		System.out.println("idiotsMap = "+idiotsMap);
		for(Entry e : idiotsMap.entrySet())
		{
			System.out.println(" I I e.getKey() = "+e.getKey());
			System.out.println(" I I e.getValue() = "+e.getValue());
		}

	}



	private static final String PATH ="/error";
	
	//private static final String PATH ="/white/error";

	@Value("${debug}")
	private boolean debug ;
	
	@Autowired
	private ErrorAttributes errorAttributes;
	
	@GetMapping(value = PATH)
	public ErrorJson error(HttpServletRequest request,HttpServletResponse response)
	{
		System.out.println("\n error() \n");
		
		ErrorJson errorJson = new ErrorJson(response.getStatus(), getAttributes(request,debug));
		
		System.out.println("errorjon recd = \n "+errorJson);
		return errorJson ;
	}
	
	private Map<String, Object> getAttributes(HttpServletRequest request, boolean includeStackTrace)
	{
		try 
		{
			System.out.println("\n getAttributes() with includestacktarce = \n"+includeStackTrace);
			
		//	ServletWebRequest extends -> webrequest exteds -> RequestAttributes
		//	RequestAttributes requestAttributes = new ServletRequestAttributes(request);
			
			RequestAttributes requestAttributes = new ServletWebRequest(request);
			
			WebRequest webRequest = null;
			if(requestAttributes instanceof WebRequest)
			{
				webRequest  = (WebRequest) requestAttributes ;
			}
			else
			{
				System.out.println("\n requestAttributes is not instanceof WebRequest\n");
			}
			
			//WebRequest webRequest2 = new ServletRequestAttributes(request);
			
			Map<String, Object> errorAttributesMap = errorAttributes.getErrorAttributes(webRequest, includeStackTrace);
			
			return errorAttributesMap ;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return new HashMap<String, Object>();
		}

	}

	@GetMapping(value = "/")
	public String getMessage()
	{
		System.out.println("\n RestController getMessage with x =  \n"+x);
		System.out.println("keeping   x as it is so  ");
		System.out.println("x = "+x);	
		
		System.out.println("keping same idiotsMap = "+idiotsMap);
		for(Entry e : idiotsMap.entrySet())
		{
			System.out.println(" I I e.getKey() = "+e.getKey());
			System.out.println(" I I e.getValue() = "+e.getValue());
		}
		
		return "Helllo SP boot , from chetan java dev with debug = "+debug ;
		
		
	}
	
	@GetMapping(value = "/1")
	public String getMessage1()
	{
		System.out.println("\n RestController getMessage1 with x =  \n"+x);
		System.out.println("assigning  x to -420 ");
		x = -420 ;
		System.out.println("x = "+x);
		
		System.out.println(" m1 idiotsMap = "+idiotsMap);
		for(Entry e : idiotsMap.entrySet())
		{
			System.out.println(" m1 b4 e.getKey() = "+e.getKey());
			System.out.println(" m1 b4 e.getValue() = "+e.getValue());
		}
		System.out.println("adding o map ");

		idiotsMap.put("Champakali by m1 ", 34);
		idiotsMap.put("gopi by m1 ",2);
		
		for(Entry e : idiotsMap.entrySet())
		{
			System.out.println(" m1 after e.getKey() = "+e.getKey());
			System.out.println(" m1 after e.getValue() = "+e.getValue());
		}
		
		
		
		return "Helllo SP boot , from chetan java dev with debug = "+debug ;
	}
	
	@GetMapping(value = "/2")
	public String getMessage2()
	{
		System.out.println("\n RestController getMessage1 with x =  \n"+x);
		System.out.println("assigning  x to 0 ");
		x=0;
		System.out.println("x = "+x);		
		
		System.out.println("m2 idiotsMap = "+idiotsMap);
		for(Entry e : idiotsMap.entrySet())
		{
			System.out.println(" m2 b4 e.getKey() = "+e.getKey());
			System.out.println(" m2  b4 e.getValue() = "+e.getValue());
		}

		idiotsMap.put("divya  by m2 ", 34);
		idiotsMap.put("huma qureshi by m2 ",2);
		for(Entry e : idiotsMap.entrySet())
		{
			System.out.println(" m2 after e.getKey() = "+e.getKey());
			System.out.println(" m2  after e.getValue() = "+e.getValue());
		}
		
		return "Helllo SP boot , from chetan java dev with debug = "+debug ;
	}
	
	
	
//	@GetMapping(value = "/3")
//	public String getMessage3()
//	{
//		System.out.println("\n RestController getMessage3 with x =  \n"+x);
//		System.out.println("assigning  x to 100 ");
//		x =100;
//		System.out.println("x = "+x);	
//		return "Helllo SP boot , from chetan java dev with debug = "+debug ;
//	}
//	  @GetMapping(value = PATH) 
//	  public String getErrorMessage() 
//	  {
//	  System.out.println("\n RestController getErrorMessage() \n"); 
//	  return   "ERror in soorryy  Helllo SP boot , from chetan java dev"; 
//	  }
	 


	@Override
	public String getErrorPath()
	{
		System.out.println("\n RestController getErrorPath() \n");
		return PATH;
		//return "srry oeerror ";
	}
	
}
