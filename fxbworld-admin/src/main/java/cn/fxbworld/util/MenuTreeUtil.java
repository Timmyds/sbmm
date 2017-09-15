package cn.fxbworld.util;



import java.util.ArrayList;
import java.util.List;

import cn.fxbworld.entity.SysMenu;
import cn.fxbworld.vo.MenuVM;

/**
 * 组装菜单树工具类
 * Created by oukingtim
 */
public class MenuTreeUtil {

	public static MenuVM getTree(List<SysMenu> list)  {

		if(list==null||list.size()<1)	return null;
		return buildTree(getRoot(list),list);
	}

	private static MenuVM buildTree(MenuVM pnode, List<SysMenu> nodes) {
		List<MenuVM> childs = new ArrayList<MenuVM>();
		for( SysMenu tmp : nodes ){
			if( pnode.getId().equals(tmp.getParentId()) ){
				childs.add(new MenuVM(tmp));
			}
		}

		if( childs.size()>0 ){
			pnode.setSubMenu(childs);
			for( MenuVM ptmp : childs ){
				buildTree(ptmp, nodes);
			}
		}
		return pnode;
	}

	private static MenuVM getRoot(List<SysMenu> list) {
		for (SysMenu po : list){
			if(po.getParentId().equals(0L)){
				return new MenuVM(po);
			}
		}
		return null;
	}
    public static List<MenuVM> getMenu(List<SysMenu> list) {

        if(list==null||list.size()<1)	return null;

        return getTree(list)==null?null:getTree(list).getSubMenu();
    }

}