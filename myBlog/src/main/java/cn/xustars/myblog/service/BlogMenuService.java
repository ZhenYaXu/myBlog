package cn.xustars.myblog.service;


import java.util.List;
import java.util.Map;

import cn.xustars.myblog.entity.BlogMenu;


/**
 * 菜单管理
 * @author user
 *
 */
public interface BlogMenuService {
	
	/**
	 * 根据父菜单，查询子菜单
	 * @param parentId 父菜单ID
	 * @param menuIdList  用户菜单ID
	 */
	List<BlogMenu> queryListParentId(Long parentId, List<Long> menuIdList);
	
	/**
	 * 获取不包含按钮的菜单列表
	 */
	List<BlogMenu> queryNotButtonList();
	
	/**
	 * 获取用户菜单列表
	 */
/*	List<BlogMenu> getUserMenuList(Long userId);*/
	
	/**
	 * 查询菜单
	 */
	BlogMenu queryObject(Long menuId);
	
	/**
	 * 查询菜单列表
	 */
	List<BlogMenu> queryList(Map<String, Object> map);
	
	/**
	 * 查询所有菜单
	 */
	List<BlogMenu> getAllMenuList(List<Long> menuIdList);
	
	/**
	 * 查询总数
	 */
	int queryTotal(Map<String, Object> map);
	
	/**
	 * 保存菜单
	 */
	void save(BlogMenu menu);
	
	/**
	 * 修改
	 */
	void update(BlogMenu menu);
	
	/**
	 * 删除
	 */
	void deleteBatch(Long[] menuIds);
}
