package com.stip.net.realm;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.stip.net.domain.User;
import com.stip.net.service.UserService;
import com.stip.net.utils.CipherUtil;

public class ShiroRealm extends AuthorizingRealm {
	private static Logger logger = LoggerFactory.getLogger(ShiroRealm.class);
	private static final String ALGORITHM = "MD5";
	
	@Resource
	private UserService userServiceImpl;

	public ShiroRealm() {
		super();
	}
	
	/**
	 * 获取授权信息
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		System.out.println(token.getUsername());
		User user = userServiceImpl.findUserByLoginName(token.getUsername());
		System.out.println(user);
		CipherUtil cipher = new CipherUtil();//MD5加密
		if (user != null) {
			return new SimpleAuthenticationInfo(user.getName(), cipher.generatePassword(user.getPassword()), getName());
		}else{
			throw new AuthenticationException();
		}
	}

	/**
	 * 获取授权信息֤
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Set<String> roleNames = new HashSet<String>();
	    Set<String> permissions = new HashSet<String>();
	    
	    roleNames.add("admin");
	    roleNames.add("administrator");
	    permissions.add("create");
	    permissions.add("login.do?main");
	    permissions.add("login.do?logout");
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
	    info.setStringPermissions(permissions);
	    
		return info;
	}


	/**
	 * 清楚缓存的授权信息
	 */
	public void clearCachedAuthorizationInfo(String principal) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
		clearCachedAuthorizationInfo(principals);
	}


	/**
	 *清楚所有授权信息
	 */
	public void clearAllCachedAuthorizationInfo() {
		Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
		if (cache != null) {
			for (Object key : cache.keys()) {
				cache.remove(key);
			}
		}
	}

}
