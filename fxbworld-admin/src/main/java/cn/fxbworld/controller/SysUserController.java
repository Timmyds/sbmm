package cn.fxbworld.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.fxbworld.entity.SysUser;
import cn.fxbworld.service.SysUserService;


/**
 * Created by oukingtim
 */
@RestController
@RequestMapping("/sys/users")
public class SysUserController extends BaseController<SysUserService,SysUser>{

}
