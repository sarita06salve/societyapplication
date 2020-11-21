package webitm.ibase.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity
@Component
@Qualifier(value = "visitors")
@Table(name = "visitors")
public class Visitors 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO , generator = "visitor_generator")
	@SequenceGenerator(name = "visitor_generator" , sequenceName = "visitor_sequence" , allocationSize = 1 , initialValue = 1)
	@Column(name = "visitorId" , nullable = false , unique = true , length = 10)
	@Getter @Setter private int visitorId;
	
	@Column(name = "visitDate" , nullable = false , unique = false )
	@NotNull(message = "Date can not be Blank!!")
	@Getter @Setter private Date visitDate;
	
	@Column(name = "vistiotorName" , nullable = false , unique = false , length = 90)
	@NotBlank(message = "Visitor's Name can't be Blank!!")
	@Getter @Setter private String vistiotorName;
	
	@Column(name = "idProofType" , nullable = false , unique = false , length = 20)
	@Getter @Setter private String idProofType;
	
	@Column(name = "proofNumber" , nullable = false , unique = false , length = 50)
	@NotBlank(message = "Proof Number can't be Blank!!")
	@Getter @Setter private String proofNumber;
	
	@Column(name = "inTime" , nullable = false , unique = false)
	@Temporal(TemporalType.TIME)
	@NotNull(message = "InTime can't be Blank!!")
	@Getter @Setter private Date inTime;
	
	@Column(name = "outTime" , nullable = false , unique = false)
	@Temporal(TemporalType.TIME)
	@NotNull(message = "OutTime can't be Blank!!")
	@Getter @Setter private Date outTime;
	
}
