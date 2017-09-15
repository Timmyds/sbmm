package cn.fxbworld.service;

import cn.fxbworld.entity.TbDict;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 字典表 服务类
 * </p>
 *
 * @author ds
 * @since 2017-09-14
 */
public interface TbDictService extends IService<TbDict> {
	 /**
     * 根据分类编号查询字典
     * @param classCode
     * @return
     */
    List<TbDict> findByClassCode(String classCode);
}
