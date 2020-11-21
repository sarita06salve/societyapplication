package webitm.ibase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity
@Component
@Qualifier(value = "vehicle")
@Table(name = "vehicle")
public class Vehicle 
{
	@Id
	@Column(name = "vehicleId" , nullable = false , unique = true , length = 10)
	@GeneratedValue(strategy = GenerationType.AUTO , generator = "vehicle_generator")
	@SequenceGenerator(name="vehicle_generator" , sequenceName = "vehicle_sequence" , initialValue = 1 , allocationSize = 1)
	@Getter @Setter private int vehicleId;
	
	@Column(name = "typeOfVehicle" , nullable = false , unique = false , length = 20)
	@Getter @Setter private String typeOfVehicle;
	
	@Column(name = "noOfVehicle" , nullable = false , unique = false , length = 1 , updatable = false)
	@Getter @Setter private int noOfVehicle;
	
	@Column(name = "vehicleNo" , nullable = false , unique = true , length = 1)
	@NotBlank(message = "Vehicle No. can't be Blank!!")
	@Getter @Setter private String vehicleNo;
	
	@ManyToOne
	@Getter @Setter private SocietyMember societyMember;
}
