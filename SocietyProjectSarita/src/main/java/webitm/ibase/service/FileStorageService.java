package webitm.ibase.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.util.StringUtils;
import lombok.Getter;
import lombok.Setter;
import webitm.ibase.controller.UploadFileController;
import webitm.ibase.model.UploadFileInfo;
import webitm.ibase.utility.ITMException;

@Service
public class FileStorageService 
{
	private UploadFileInfo uploadFileInfo;
	
	private final Path fileStorageLocation;

	FileStorageService()
	{
		fileStorageLocation = Paths.get("D://uploadedFile");
	}

	public void init() 
	{
		try 
		{
			Files.createDirectory(fileStorageLocation);
		} 
		catch (IOException e) 
		{
			throw new RuntimeException("Could not initialize folder for upload!");
		}
	}

	public String storeFile(MultipartFile file) throws Exception , IOException
	{
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		try 
		{
			Files.copy(file.getInputStream(), this.fileStorageLocation.resolve(fileName));
		} 
		catch (Exception e) 
		{
			throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
		}
		return fileName;
	}
	
	public Resource load(String fileName) throws ITMException
	{
		try
		{
			Path file = fileStorageLocation.resolve(fileName);
			Resource resource = new UrlResource(file.toUri());
			
			if(resource.exists() || resource.isReadable())
			{
				return resource;
			}
			else
			{
				throw new RuntimeException("Could not read the file");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new ITMException(e);
		}
	}
	
	public List<String> getAllFileList() throws ITMException
	{
		 List<String> fileList = new ArrayList<String>();
		try
		{
			File file = new File("D://uploadedFile");
			File[] listOfFiles = file.listFiles();
			
			for(File file1 : listOfFiles)
			{
				if(file1.isFile())
				{
					String fileName = file1.getName();
					fileList.add(fileName);
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new ITMException(e);
		}
		System.out.println(fileList);
		return fileList;
	}
	
	public Resource loadFileAsResource(String fileName) throws ITMException
	{
		try
		{
			Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
			Resource resource = new UrlResource(filePath.toUri());
			if(resource.exists())
			{
				return resource;
			}
			else
			{
				throw new FileNotFoundException("File not found " + fileName);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new ITMException(e);
		}
	}
}
