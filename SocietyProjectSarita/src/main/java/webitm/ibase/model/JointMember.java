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
@Component
@Entity
@Qualifier(value = "jointMember")
@Table(name = "jointMember")
public class JointMember 
{
	@Id
	@Column(name = "jointMemberId" , nullable = false , unique = true , length = 10)
	@GeneratedValue(strategy = GenerationType.AUTO , generator = "jointmem_generator")
	@SequenceGenerator(name="jointmem_generator" , sequenceName = "jointmem_sequence" , initialValue = 1 , allocationSize = 1)
	@Getter @Setter private int jointMemberId;
	
	@Column(name = "jointMember_maiden" , nullable = false , unique = false , length = 5)
	@Getter @Setter private String jointMember_maiden;
	
	@Column(name = "jointMember_firstName" , nullable = false , unique = false , length = 30)
	@NotBlank(message = "JointMember First Name can't be Blank!!")
	@Getter @Setter private String jointMember_firstName;
	
	@Column(name = "jointMember_middleName" , nullable = false , unique = false , length = 30)
	@NotBlank(message = "JointMember Middle Name can't be Blank!!")
	@Getter @Setter private String jointMember_middleName;
	
	@Column(name = "jointMember_lastName" , nullable = false , unique = false , length = 30)
	@NotBlank(message = "JointMember Last Name can't be Blank!!")
	@Getter @Setter private String jointMember_lastName;
	
	@Column(name = "jointMember_mobileNo" , nullable = false , unique = false , length = 10)
	@NotBlank(message = "JointMember Mobile  No. can't be Blank!!")
	@Getter @Setter private String jointMember_mobileNo;
}
