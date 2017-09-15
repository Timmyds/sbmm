package cn.fxbworld.controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

import cn.fxbworld.entity.TbCalendar;
import cn.fxbworld.service.TbCalendarService;
import cn.fxbworld.util.ShiroUtils;
import cn.fxbworld.vo.ResultVM;

/**
 * Created by oukingtim
 */
@RestController
@RequestMapping("/sys/calendar")
public class TbCalendarController extends BaseController<TbCalendarService, TbCalendar> {

    @GetMapping("/getlist")
    public ResultVM getList() {
        TbCalendar calendar = new TbCalendar();
        calendar.setCreateUserId(ShiroUtils.getUserId());
        List<TbCalendar> list = service.selectList(new EntityWrapper<>(calendar));
        return ResultVM.ok(list);
    }
}
