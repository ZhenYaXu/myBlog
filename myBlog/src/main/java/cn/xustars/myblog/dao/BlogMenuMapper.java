package cn.xustars.myblog.dao;

import cn.xustars.myblog.entity.BlogMenu;

import java.util.List;
import java.util.Map;

/**
 * 菜单管理
 * 
 * @author user
 * 
 */
public interface BlogMenuMapper {
	
	/**
	 * 根据父菜单，查询子菜单
	 * @param parentId 父菜单ID
	 */
	List<BlogMenu> queryListParentId(Long parentId);
	
	/**
	 * 获取不包含按钮的菜单列表
	 */
	List<BlogMenu> queryNotButtonList();

	void deleteBatch(Long[] menuIds);

	void update(BlogMenu menu);

	void save(BlogMenu menu);

	int queryTotal(Map<String, Object> map);

	List<BlogMenu> queryList(Map<String, Object> map);

	BlogMenu queryObject(Long menuId);
}
