package cn.fxbworld.controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.fxbworld.entity.SysRole;
import cn.fxbworld.service.SysRoleService;
import cn.fxbworld.vo.ResultVM;



/**
 * Created by oukingtim
 */
@RestController
@RequestMapping("/sys/role")
public class SysRoleController extends BaseController<SysRoleService, SysRole> {

    /**
     * 获取角色集合
     */
    @GetMapping("/getlist")
    public ResultVM getList(@RequestParam(required = false) String userId) {
        List<SysRole> roleList = service.getList(userId);
        return ResultVM.ok(roleList);
    }
}
