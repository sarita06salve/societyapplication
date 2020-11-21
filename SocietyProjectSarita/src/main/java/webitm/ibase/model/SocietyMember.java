package webitm.ibase.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;

@ToString
@Component
@Entity
//@Qualifier(value = "societyMember")
@Table(name = "societyMember")
public class SocietyMember 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO , generator = "societymem_generator")
	@SequenceGenerator(name="societymem_generator" , sequenceName = "societymem_sequence" , initialValue = 1 , allocationSize = 1)
	@Column(name = "memberId" , nullable = false , unique = true , length = 10)
	@Getter @Setter private int memberId;
	
	@Column(name = "maiden" , nullable = false , unique = false , length = 5)
	@Getter @Setter private String maiden;
	
	@Column(name = "member_firstName" , nullable = false , unique = false , length = 30)
	@NotBlank(message = "Member First Name can't be Blank!!")
	@Getter @Setter private String member_firstName;
	
	@Column(name = "member_middleName" , nullable = false , unique = false , length = 30)
	@NotBlank(message = "Member Middle Name can't be Blank!!")
	@Getter @Setter private String member_middleName;
	
	@Column(name = "member_lastName" , nullable = false , unique = false , length = 30)
	@NotBlank(message = "Member Last Name can't be Blank!!")
	@Getter @Setter private String member_lastName;
	
	@Column(name = "member_bldgName" , nullable = false , unique = false , length = 1)
	@Getter @Setter private String member_bldgName;
	
	@Column(name = "member_bldgNo" , nullable = false , unique = false , length = 5)
	@NotBlank(message = "Building No. can't be Blank!!")
	@Getter @Setter private String member_bldgNo;
	
	@Column(name = "member_blockNo" , nullable = false , unique = false , length = 5)
	@NotBlank(message = "Block No. can't be Blank!!")
	@Getter @Setter private String member_blockNo;
	
	@Column(name = "member_mobileNo" , nullable = false , unique = true , length = 10)
	@NotBlank(message = "Mobile No. can't be Blank!!")
	@Getter @Setter private String member_mobileNo;
	
	@Column(name = "member_altMobileNo" , nullable = false , unique = false , length = 10)
	@NotBlank(message = "Alternate Mobile No. can't be Blank!!")
	@Getter @Setter private String member_altMobileNo;
	
	@Column(name = "member_registrationNo" , nullable = false , unique = true , length = 30)
	@NotBlank(message = "Member Registration No. can't be Blank!!")
	@Getter @Setter private String member_registrationNo;
	
	@Column(name = "member_isJoint" , nullable = false , unique = false , length = 5)
	@Getter @Setter private String member_isJoint;
	
	@OneToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
	@Getter @Setter private List<JointMember> jointMember;
}
