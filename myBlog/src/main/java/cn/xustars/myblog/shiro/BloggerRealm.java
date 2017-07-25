package cn.xustars.myblog.shiro;

import cn.xustars.myblog.entity.BloggerInfo;
import cn.xustars.myblog.service.BloggerService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * shiro 自定义Realm
 * @author user
 *
 */
public class BloggerRealm extends AuthorizingRealm{

	@Autowired
	private BloggerService bloggerService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		return null;
	}

	/**
	 * 用户认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		String password = new String ((char[]) token.getCredentials());

		BloggerInfo bloggerInfo = bloggerService.queryByUserName(username);

		//账号不存在
		if(bloggerInfo == null) {
			throw new UnknownAccountException("账号或密码不正确");
		}

		//密码错误
		if(!password.equals(bloggerInfo.getPassword())) {
			throw new IncorrectCredentialsException("账号或密码不正确");
		}


		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username,password,getName());
		return simpleAuthenticationInfo;
	}

}
