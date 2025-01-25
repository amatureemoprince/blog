package com.lj.blog.domain.serivce.imp;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.IdUtil;
import com.lj.blog.common.enums.GlobalEnum;
import com.lj.blog.common.exception.exceptions.BusinessException;
import com.lj.blog.common.result.Result;
import com.lj.blog.common.satoken.StpKit;
import com.lj.blog.domain.convert.BlogUserInfoBoConvert;
import com.lj.blog.domain.entity.BlogUserInfoRspBo;
import com.lj.blog.domain.entity.BlogUserLoginBo;
import com.lj.blog.domain.serivce.BlogUserDomainService;
import com.lj.blog.infra.basic.entity.BlogUser;
import com.lj.blog.infra.basic.service.impl.BlogUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;

/**
 * @ClassName BlogUserDomainServiceImp
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/20 14:21
 * @Version JDK 17
 */
@Service
public class BlogUserDomainServiceImp implements BlogUserDomainService {

    @Autowired
    private BlogUserServiceImpl blogUserService;

    @Autowired
    private BlogUserInfoBoConvert infoBoConvert;

    @Override
    public Result<String> register(BlogUser blogUser) {
        BlogUser blogUserD = new BlogUser();
        blogUserD.setEmail(blogUser.getEmail());
        List<BlogUser> blogUsers = blogUserService.queryPrimary(blogUserD);
        if(!CollectionUtil.isEmpty(blogUsers)){
            return Result.error("该邮箱已经被注册了");
        }
        long snowflakeNextId = IdUtil.getSnowflakeNextId();
        String userName = GlobalEnum.WEBSITE_NAME.getMsg() + "_" + snowflakeNextId;
        //使用生成的userName
        blogUser.setUserName(userName);
        BlogUser insert = blogUserService.insert(blogUser);
        if(insert != null){
            return Result.success("注册成功");
        }
        return Result.error("注册失败");
    }
    /**
     * @Description 用户登录：可以使用邮箱或者用户名
     * */
    @Override
    public Result<SaTokenInfo> login(BlogUserLoginBo blogUserLoginBo) {
        BlogUser blogUser = new BlogUser();
        //若是用户名则查询user_name
        if(!checkEmail(blogUserLoginBo.getUserName())){
            //设置需要查询的条件
            blogUser.setUserName(blogUserLoginBo.getUserName());
            blogUser.setIsDeleted(GlobalEnum.IS_NOT_DELETED.getCode());
            SaTokenInfo saTokenInfo = loginByEmailOrUserName(blogUser, blogUserLoginBo.getPassword());
            return Result.success(saTokenInfo);
        }
        //若是email则查询email
        blogUser.setEmail(blogUserLoginBo.getUserName());
        blogUser.setIsDeleted(GlobalEnum.IS_NOT_DELETED.getCode());
        SaTokenInfo saTokenInfo = loginByEmailOrUserName(blogUser, blogUserLoginBo.getPassword());
        return Result.success(saTokenInfo);
    }


    /**
     * @Description 获取用户信息
     * */
    @Override
    public BlogUserInfoRspBo getBlogUserInfo() {
        String loginId = (String) StpKit.USER.getLoginId();
        BlogUser blogUser = blogUserService.queryById(Long.parseLong(loginId));
        return infoBoConvert.blogUserInfoToBo(blogUser);
    }
    /**
     * 根据用户id查询权限集合
     * */
    @Override
    public Set<String> getPermissionListById(long id) {
        return Set.of();
    }



    /**
     * Description 判断邮箱，是返回true，不是返回false
     * */
    private boolean checkEmail(String userName){
        return userName.contains("@");
    }

    /**
     * Description 传入blogUser和password
     * password是前端传递的数据
     * blogUser是查询设置好的userName和isDeleted
     * */
    private SaTokenInfo loginByEmailOrUserName(BlogUser blogUser, String password){
        List<BlogUser> blogUsers = blogUserService.queryPrimary(blogUser);
        if(CollectionUtil.isEmpty(blogUsers)){
            throw new BusinessException("该用户不存在");
        }
        if(!blogUsers.get(0).getPassword().equals(password)){
            throw new BusinessException("密码错误");
        }
        StpKit.USER.login(blogUsers.get(0).getId());
        return StpKit.USER.getTokenInfo();
    }
}
