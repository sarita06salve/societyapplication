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

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity
@Component
@Qualifier(value = "expenseVoucher")
@Table(name = "expenseVoucher")
public class ExpenseVoucher 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO , generator = "expense_generator")
	@SequenceGenerator(name = "expense_generator" , sequenceName = "expensevoucher_generator" , initialValue = 1 , allocationSize = 1)
	@Column(name = "expVouchId" , nullable = false , unique = true , length = 10)
	@Getter @Setter private int expVouchId;
	
	@Column(name = "expVouchDate" , nullable = false , unique = false)
	@Temporal(TemporalType.DATE)
	@Getter @Setter private Date expVouchDate;
	
	@Column(name = "incVouchType" , nullable = false , unique = false , length = 20)
	@Getter @Setter private String expVouchType;
	
	@Column(name = "expVouchDescription" , nullable = false , unique = false , length = 300)
	@NotBlank(message = "Description can not be Blank!!!")
	@Getter @Setter private String expVouchDescription;
	
	@Column(name = "expVouchAmount" , nullable = false , unique = false , precision = 20 , scale = 3)
	@Getter @Setter private double expVouchAmount;
	
	@Column(name = "expVouchAmtRs" , nullable = false , unique = false , length = 150)
	@NotBlank(message = "Please mention amount in Rupees..")
	@Getter @Setter private String expVouchAmtRs;
}
