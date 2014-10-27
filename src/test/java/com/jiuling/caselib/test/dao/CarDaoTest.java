package com.jiuling.caselib.test.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.util.Assert;

import cn.jiuling.comparesystem.dao.CarDao;
import cn.jiuling.comparesystem.vo.CarQuery;
import cn.jiuling.comparesystem.vo.Pager;

import com.jiuling.caselib.test.BaseTest;

public class CarDaoTest extends BaseTest {
	@Resource
	private CarDao carDao;

	@Test
	public void testFindCarBySeriesId() {
		Integer seriesId = 1;
		List list = carDao.findCar(seriesId);
		Assert.notEmpty(list);
	}

	@Test
	public void testFindCarByCarQuery() {
		CarQuery c = new CarQuery();
		c.setOpenType((short) 1);
		Pager p = carDao.findCar(c, 1, 10);
		Assert.notEmpty(p.getRows());
	}

}
