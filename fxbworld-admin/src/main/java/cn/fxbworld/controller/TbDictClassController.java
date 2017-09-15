package cn.fxbworld.controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

import cn.fxbworld.entity.TbDictClass;
import cn.fxbworld.service.TbDictClassService;
import cn.fxbworld.vo.ResultVM;

/**
 * Created by oukingtim
 */
@RestController
@RequestMapping("/sys/dictclass")
public class TbDictClassController extends BaseController<TbDictClassService, TbDictClass> {

    /**
     * 获取字典分类集合
     * @return
     */
    @GetMapping("/getlist")
    public ResultVM getList() {
        List<TbDictClass> list = service.selectList(new EntityWrapper<>());
        return ResultVM.ok(list);
    }
}
