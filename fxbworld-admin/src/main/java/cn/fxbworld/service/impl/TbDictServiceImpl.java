package cn.fxbworld.service.impl;

import cn.fxbworld.entity.TbDict;
import cn.fxbworld.mapper.TbDictMapper;
import cn.fxbworld.service.TbDictService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 字典表 服务实现类
 * </p>
 *
 * @author ds
 * @since 2017-09-14
 */
@Service
public class TbDictServiceImpl extends ServiceImpl<TbDictMapper, TbDict> implements TbDictService {
	@Override
	public List<TbDict> findByClassCode(String classCode) {
		return baseMapper.selectByClassCode(classCode);
	}
}
