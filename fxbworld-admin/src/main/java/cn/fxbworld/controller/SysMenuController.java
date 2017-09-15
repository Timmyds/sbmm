package cn.fxbworld.controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.fxbworld.entity.SysMenu;
import cn.fxbworld.service.SysMenuService;
import cn.fxbworld.vo.JsTreeVM;
import cn.fxbworld.vo.ResultVM;

/**
 * Created by oukingtim
 */
@RestController
@RequestMapping("/sys/menu")
public class SysMenuController extends BaseController<SysMenuService,SysMenu>{

    /**
     * 获取菜单树
     * @param roleId
     * @return
     */
    @GetMapping("/getMenuTree")
    public ResultVM getMenuTree(@RequestParam(required = false) Long roleId) {
        List<JsTreeVM> list = service.getMenuTree(roleId);
        return ResultVM.ok(list);
    }
}
