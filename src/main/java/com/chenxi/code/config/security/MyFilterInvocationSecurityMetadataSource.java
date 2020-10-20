package com.chenxi.code.config.security;


import com.chenxi.code.sys.user.entity.MenuEntity;
import com.chenxi.code.sys.user.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
public class MyFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private MenuService menuService;

    private HashMap<String, Collection<ConfigAttribute>> map = null;

    /*
    *加载权限表中所有的权限
    *name:xurenxin
    *time:2020/10/19 11:56
    */
    public  void loadResourceDefine(){
        map = new HashMap<>();

        List<MenuEntity> menuList = menuService.menuAll();
        menuList.forEach(menu ->{
            ConfigAttribute cfg = new SecurityConfig(menu.getName());
            List<ConfigAttribute> list = new ArrayList<>();
            list.add(cfg);
            map.put(menu.getUrl(),list);
        });
    }
    /*
     * 此方法是为了判定用户请求的url 是否在权限表中，如果在权限表中，则返回给 decide 方法， 用来判定用户
     * 是否有此权限。如果不在权限表中则放行。
    *name:xurenxin
    *time:2020/10/19 11:53
    */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
       if (map == null){
           loadResourceDefine();
       }
        HttpServletRequest request = ((FilterInvocation) o).getHttpRequest();
        for (Map.Entry<String, Collection<ConfigAttribute>> entry : map.entrySet()) {
            String url = entry.getKey();
            if (new AntPathRequestMatcher(url).matches(request)) {
                return map.get(url);
            }
        }
       return null;
    }

    /*
    *获取该SecurityMetadataSource对象中保存的针对所有安全对象的权限信息的集合
    * 该方法的主要目的是被AbstractSecurityInterceptor用于启动时校验每个ConfigAttribute对象。
    *name:xurenxin
    *time:2020/10/19 11:51
    */
    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    /*
    *这里clazz表示安全对象的类型，该方法用于告知调用者当前SecurityMetadataSource是否支持此类安全对象，
    * 只有支持的时候，才能对这类安全对象调用getAttributes方法。
    *name:xurenxin
    *time:2020/10/19 11:49
    */
    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
