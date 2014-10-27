package cn.jiuling.comparesystem.dao.impl;

import org.springframework.stereotype.Repository;

import cn.jiuling.comparesystem.dao.BrandDao;
import cn.jiuling.comparesystem.model.Brand;

@Repository("brandDao")
public class BrandDaoImpl extends BaseDaoImpl<Brand> implements BrandDao {

}
