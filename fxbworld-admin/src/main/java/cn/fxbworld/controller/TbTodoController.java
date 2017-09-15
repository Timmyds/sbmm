package cn.fxbworld.controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

import cn.fxbworld.entity.TbTodo;
import cn.fxbworld.service.TbTodoService;
import cn.fxbworld.util.ShiroUtils;
import cn.fxbworld.vo.ResultVM;

/**
 * Created by oukingtim
 */
@RestController
@RequestMapping("/sys/todo")
public class TbTodoController extends BaseController<TbTodoService, TbTodo> {

    @GetMapping("/getlist")
    public ResultVM getList() {
        TbTodo tbTodo = new TbTodo();
        tbTodo.setCreateUserId(ShiroUtils.getUserId());
        List<TbTodo> list = service.selectList(new EntityWrapper<>(tbTodo));
        return ResultVM.ok(list);
    }
}
