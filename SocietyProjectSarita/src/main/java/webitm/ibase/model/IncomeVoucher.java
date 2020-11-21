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

import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
@Component
@Entity
@Qualifier(value = "incomeVoucher")
@Table(name = "incomeVoucher")
public class IncomeVoucher 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO , generator = "income_generator")
	@SequenceGenerator(name="income_generator" , sequenceName = "incomevouch_sequence" , initialValue = 1 , allocationSize = 1)
	@Column(name = "incVouchId" , nullable = false , unique = true , length = 10)
	@Getter @Setter private int incVouchId;
	
	@Column(name = "incVouchDate" , nullable = false , unique = false)
	@Temporal(TemporalType.DATE)
	@Getter @Setter private Date incVouchDate;
	
	@Column(name = "incVouchType" , nullable = false , unique = false , length = 20)
	@Getter @Setter private String incVouchType;
	
	@Column(name = "incVouchDescription" , nullable = false , unique = false , length = 300)
	@NotBlank(message = "Description can not be Blank!!!")
	@Getter @Setter private String incVouchDescription;
	
	@Column(name = "incVouchAmount" , nullable = false , unique = false , precision = 20 , scale = 3)
	@Getter @Setter private double incVouchAmount;
	
	@Column(name = "incVouchAmtRs" , nullable = false , unique = false , length = 150)
	@NotBlank(message = "Please mention amount in Rupees..")
	@Getter @Setter private String incVouchAmtRs;
}
