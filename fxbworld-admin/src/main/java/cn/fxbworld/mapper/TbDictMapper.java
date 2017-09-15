package cn.fxbworld.mapper;

import cn.fxbworld.entity.TbDict;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  * 字典表 Mapper 接口
 * </p>
 *
 * @author ds
 * @since 2017-09-14
 */
public interface TbDictMapper extends BaseMapper<TbDict> {
	 /**
     * 根据分类编号查询字典数据
     * @param classCode
     * @return
     */
    List<TbDict> selectByClassCode(String classCode);
}