package cn.xustars.myblog.service.impl;


import cn.xustars.myblog.dao.BlogMenuMapper;
import cn.xustars.myblog.entity.BlogMenu;
import cn.xustars.myblog.service.BlogMenuService;
import cn.xustars.myblog.utils.Constant.MenuType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class BlogMenuServiceImpl implements BlogMenuService {
	@Autowired
	private BlogMenuMapper sysMenuDao;

	public List<BlogMenu> queryListParentId(Long parentId, List<Long> menuIdList) {
		List<BlogMenu> menuList = sysMenuDao.queryListParentId(parentId);
		if(menuIdList == null){
			return menuList;
		}

		List<BlogMenu> userMenuList = new ArrayList<BlogMenu>();
		for(BlogMenu menu : menuList){
			if(menuIdList.contains(menu.getMenuId())){
				userMenuList.add(menu);
			}
		}
		return userMenuList;
	}


	public List<BlogMenu> queryNotButtonList() {
		return sysMenuDao.queryNotButtonList();
	}



	public List<BlogMenu> queryList(Map<String, Object> map) {
		return sysMenuDao.queryList(map);
	}


	public int queryTotal(Map<String, Object> map) {
		return sysMenuDao.queryTotal(map);
	}


	public void save(BlogMenu menu) {
		sysMenuDao.save(menu);
	}


	public void update(BlogMenu menu) {
		sysMenuDao.update(menu);
	}


	@Transactional
	public void deleteBatch(Long[] menuIds) {
		sysMenuDao.deleteBatch(menuIds);
	}


	public BlogMenu queryObject(Long menuId) {
		return sysMenuDao.queryObject(menuId);
	}

	/**
	 * 获取所有菜单列表
	 */
	public List<BlogMenu> getAllMenuList(List<Long> menuIdList) {
		//查询根菜单列表
		List<BlogMenu> menuList = queryListParentId(0L, menuIdList);
		//递归获取子菜单
		getMenuTreeList(menuList, menuIdList);

		return menuList;
	}

	/**
	 * 递归
	 */
	private List<BlogMenu> getMenuTreeList(List<BlogMenu> menuList, List<Long> menuIdList){
		List<BlogMenu> subMenuList = new ArrayList<BlogMenu>();

		for(BlogMenu entity : menuList){
			if(entity.getType() == MenuType.CATALOG.getValue()){//目录
				entity.setList(getMenuTreeList(queryListParentId(entity.getMenuId(), menuIdList), menuIdList));
			}
			subMenuList.add(entity);
		}

		return subMenuList;
	}
}
