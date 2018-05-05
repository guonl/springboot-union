package com.guonl.service;

import com.guonl.common.ServerResponse;
import com.guonl.vo.UserVo;

import java.util.List;

/**
 * Created by guonl
 * Date 2018/5/2 下午9:49
 * Description:
 */
public interface UserService {

    ServerResponse<List<UserVo>> getAllUser();
}
