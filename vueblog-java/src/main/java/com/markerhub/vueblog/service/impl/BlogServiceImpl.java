package com.markerhub.vueblog.service.impl;

import com.markerhub.vueblog.entity.Blog;
import com.markerhub.vueblog.mapper.BlogMapper;
import com.markerhub.vueblog.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author local
 * @since 2022-08-15
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
