package webitm.ibase.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import webitm.ibase.service.FileStorageService;
import webitm.ibase.utility.ITMException;

@Controller
public class downloadFileController 
{
	@Autowired
	private FileStorageService fileStorageService;
	
	/*@RequestMapping(value="/home/downloadSelectFile/{fileName}" , method = RequestMethod.GET)
	public ModelAndView getFileNameForDownload(@PathVariable("fileName") String fileName) throws ITMException
	{
		ModelAndView modelAndView = new ModelAndView();
	   String contentType = null;
		try
		{
			List<String> fileList =  fileStorageService.getAllFileList();			
			modelAndView.addObject("fileList", fileList);
			modelAndView.setViewName("downloadSocietyFile");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new ITMException(e);
		}
		return modelAndView;
	}*/
	
	@RequestMapping(value="/home/downloadSelectFile/{fileName}" , method = RequestMethod.GET)
	public ModelAndView getFileNameForDownload(@PathVariable("fileName") String fileName,HttpServletRequest request) throws ITMException
	{
		ModelAndView modelAndView = new ModelAndView();
	   String contentType = null;
		try
		{
			Resource resource = fileStorageService.loadFileAsResource(fileName);
			System.out.println("Hi.. Hi... Hi.." + resource);
			try
			{
				contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
			}
			catch(Exception e) {e.printStackTrace();}
			if(contentType == null) {
	            contentType = "application/octet-stream";
	        }
			
			List<String> fileList =  fileStorageService.getAllFileList();			
			modelAndView.addObject("fileList", fileList);
			
			modelAndView.setViewName("downloadSocietyFile");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new ITMException(e);
		}
		return modelAndView;
	}
}
