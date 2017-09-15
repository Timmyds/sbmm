package cn.fxbworld.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.fxbworld.entity.TArticle;
import cn.fxbworld.service.TArticleService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ds
 * @since 2017-09-14
 */
@Controller
@RequestMapping("/tArticle")
public class TArticleController extends BaseController<TArticleService, TArticle> {
	
}
