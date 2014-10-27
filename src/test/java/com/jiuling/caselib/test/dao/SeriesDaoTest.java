package com.jiuling.caselib.test.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.util.Assert;

import cn.jiuling.comparesystem.dao.SeriesDao;

import com.jiuling.caselib.test.BaseTest;

public class SeriesDaoTest extends BaseTest {
	@Resource
	private SeriesDao seriesDao;

	@Test
	public void testFindCarBySeriesId() {
		List list = seriesDao.fetchSeries();
		Assert.notEmpty(list);
	}

}
