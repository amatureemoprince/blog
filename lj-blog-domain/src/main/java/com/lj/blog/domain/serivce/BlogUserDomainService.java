package com.lj.blog.domain.serivce;
import cn.dev33.satoken.stp.SaTokenInfo;
import com.lj.blog.common.result.Result;
import com.lj.blog.domain.entity.BlogUserInfoRspBo;
import com.lj.blog.domain.entity.BlogUserLoginBo;
import com.lj.blog.infra.basic.entity.BlogUser;
import java.util.Set;

/**
 * @ClassName BlogUserDomainService
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/20 14:21
 * @Version JDK 17
 */
public interface BlogUserDomainService {

    Result<String> register(BlogUser blogUser);

    Result<SaTokenInfo> login(BlogUserLoginBo blogUserLoginBo);

    BlogUserInfoRspBo getBlogUserInfo();

    Set<String> getPermissionListById(long l);

}
