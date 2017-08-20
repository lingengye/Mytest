package cn.lingy.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lingy.crm.po.TbUser;
import cn.lingy.crm.service.UserService;


@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//查询用户列表
	@RequestMapping("users")
	public String users(){
		return "users";
	}
	
	@RequestMapping("list")
	@ResponseBody
	public List<TbUser> list(){
		
		List<TbUser> list = userService.queryUserList();
		
		return list;
	}
	
	@RequestMapping("userAdd")
	public String userAdd(){
		return "user-add";
	}
	
	@RequestMapping("save")
	public String save(TbUser tbUser){
		userService.saveUser(tbUser);
		return "redirect:list";
	}
	
	@RequestMapping("queryUserById")
	public String queryUserById(Model model,String ids){
		TbUser user = userService.queryUserById(Long.parseLong(ids));
		model.addAttribute("user", user);
		return "user-edit";
	}
	
	
	@RequestMapping("updateUser")
	public String updateUser(TbUser tbUser){
		userService.updateUser(tbUser);
		return "redirect:list";
	}
	
	@RequestMapping("deleteUserByIds")
	public String deleteUserByIds(String[] ids){
		userService.deleteUserByIds(ids);
		return "redirect:list";
	}
	
	
	
//	@RequestMapping("queryCustById")
//	public String queryCustById(Model model,Integer custId){
//		
//		Customer cust = customerService.queryCustomById(custId);
//		model.addAttribute("cust", cust);
//		
//		
//		//信息来源
//		List<BaseDict> fromType = baseDictService.queryTypeCode("002");
//		//行业
//		List<BaseDict> industryType = baseDictService.queryTypeCode("001");
//		//客户级别
//		List<BaseDict> levelType = baseDictService.queryTypeCode("006");
//		
//		
//		model.addAttribute("fromType",fromType);
//		model.addAttribute("industryType",industryType);
//		model.addAttribute("levelType",levelType);
//		
//		return "custom/customerEdit";
//	}
//	
//	@RequestMapping("update")
//	public String update(Customer customer){
//		
//		customerService.updateCustomById(customer);
//		
//		return "redirect:list";
//	}
//	@RequestMapping("deleteCustById")
//	public String deleteCustById(Integer custId){
//		
//		customerService.deleteCustomById(custId);
//		
//		return "redirect:list";
//	}
//	
	
}
