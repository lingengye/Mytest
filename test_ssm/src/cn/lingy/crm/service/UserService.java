package cn.lingy.crm.service;

import java.util.List;

import cn.lingy.crm.po.TbUser;

public interface UserService {
	//用户列表
	List<TbUser> queryUserList();
	//根据id查找
	TbUser queryUserById(Long id);
//	
//	void updateCustomById(Customer customer);
//	
//	void deleteCustomById(Integer id);
	//更新
	void updateUser(TbUser tbUser);
	//删除
	void deleteUserByIds(String[] ids);
	//保存
	void saveUser(TbUser tbUser);
	
}
