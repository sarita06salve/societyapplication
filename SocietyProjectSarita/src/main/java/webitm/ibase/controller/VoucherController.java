package webitm.ibase.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VoucherController 
{
	@RequestMapping(value = "/home/voucher")
	public String viewVoucherPage()
	{
		return "vouchers";
	}
}
