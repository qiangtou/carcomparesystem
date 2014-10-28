package cn.jiuling.comparesystem.dao;

import java.util.List;

import cn.jiuling.comparesystem.model.Carpic;

public interface CarpicDao extends BaseDao<Carpic> {

	public List findPic(Integer carTypeId);

}
