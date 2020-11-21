package webitm.ibase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;

import webitm.ibase.model.UploadFileInfo;
import webitm.ibase.service.FileStorageService;
import webitm.ibase.utility.ITMException;

@Controller
public class UploadFileController 
{
	 @Autowired
	 private FileStorageService fileStorageService;
	 
	@RequestMapping(value = "/home/uploadSocFile")
	public String uploadControllerPage()
	{
		return "uploadSocietyFile";
	}
	
	@RequestMapping(value = "/home/uploadselectfile" , method = RequestMethod.GET)
	public ModelAndView uploadSelectedFile() throws ITMException
	{
		ModelAndView modelAndView = new ModelAndView();
		try
		{
			modelAndView.setViewName("uploadSocietyFile");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new ITMException(e);
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/home/uploadselectfile" , headers=("content-type=multipart/form-data") , method = RequestMethod.POST)
	public ModelAndView uploadSelectedFile(@RequestParam("noticefile")MultipartFile file) throws ITMException
	{
		ModelAndView modelAndView = new ModelAndView();
		try
		{
			System.out.println("Inside Upload File .... ");
			String fileName = fileStorageService.storeFile(file);
			
			System.out.println("Hello ...." + fileName);
			
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
