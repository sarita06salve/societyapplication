package webitm.ibase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Qualifier(value = "committeeMember")
@Component
@Entity
@Table(name = "committeemember")
public class SocietyCommitteeMember 
{
	 
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "author_generator")
	@SequenceGenerator(name="author_generator" , sequenceName = "auth_sequence" , initialValue = 1 , allocationSize = 1)
	@Column(name = "scmId" , length = 10 , nullable = false , unique = true)
	@Getter @Setter private int scmId;
	
	 
	@Column(name = "maiden" , length = 5 , nullable = false , unique = false)
	@Getter @Setter private String maiden;
	
	
	@Column(name = "scm_firstName" , length = 30 , nullable = false , unique = false)
	@NotBlank(message = "First Name Can't Blank!!!")
	@Getter @Setter private String scm_firstName;
	
	
	@Column(name = "scm_middleName" , length = 30 , nullable = false , unique = false)
	@NotBlank(message = "Middle Name Can't Blank!!!")
	@Getter @Setter private String scm_middleName;
	
	
	@Column(name = "scm_lastName" , length = 30 , nullable = false , unique = false)
	@NotBlank(message = "Last Name Can't Blank!!!")
	@Getter @Setter private String scm_lastName;
	
	
	@Column(name = "scm_mobileNo" , length = 10 , nullable = false , unique = false)
	@NotBlank(message = "Mobile No Can't Blank")
	@Getter @Setter private String scm_mobileNo;
	
	
	@Column(name = "scm_designation" , length = 20 , nullable = false , unique = false)
	@Getter @Setter private String scm_designation;
}
