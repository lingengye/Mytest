package cn.lingy.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lingy.crm.mapper.TbUserMapper;
import cn.lingy.crm.po.TbUser;
import cn.lingy.crm.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private TbUserMapper tbUserMapper;
	
	//查询用户列表
	@Override
	public List<TbUser> queryUserList() {
		
		return tbUserMapper.selectByExample(null);
	}

	@Override
	public TbUser queryUserById(Long id) {
		
		return tbUserMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateUser(TbUser tbUser) {
		tbUserMapper.updateByPrimaryKeySelective(tbUser);
		
	}

	@Override
	public void deleteUserByIds(String[] ids) {
		for (String id : ids) {
			long uid = Long.parseLong(id);
			tbUserMapper.deleteByPrimaryKey(uid);
		}
		
	}

	@Override
	public void saveUser(TbUser tbUser) {
		tbUserMapper.insert(tbUser);
	}

}
