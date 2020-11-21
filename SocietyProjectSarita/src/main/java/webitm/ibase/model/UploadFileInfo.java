package webitm.ibase.model;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Component
public class UploadFileInfo 
{
	@Getter @Setter private String fileName;
	@Getter @Setter private String fileUri;
	
	UploadFileInfo(){}
	public UploadFileInfo(String fileName, String fileUri) {
		super();
		this.fileName = fileName;
		this.fileUri = fileUri;
		
	}
	
	
}
