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
	 * 登录鉴权
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
	 * 授权验证
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		//获取登录时输入的用户名
        String loginName = (String)principalCollection.fromRealm(getName()).iterator().next();
        //获取当前的用户名,跟上面的一样
        String currentUsername = (String)super.getAvailablePrincipal(principalCollection);
 
        User user = userServiceImpl.findUserByLoginName(loginName);
        if (user != null) {
            //权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
 
            //用户的角色集合
            simpleAuthorizationInfo.setRoles(user.getRolesName());
 
            //对应角色的权限
            List<TRole> roles = user.getRoles();
            for (TRole role:roles){
                simpleAuthorizationInfo.addStringPermissions(role.getPermissionName());
            }
 
 
            return simpleAuthorizationInfo;
        }
        return null;
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
