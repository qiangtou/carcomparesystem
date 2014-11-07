package cn.jiuling.comparesystem.utils.autohome;

import java.util.List;

public class MyRunnable implements Runnable {

	public List list;
	public int fromIndex;

	@Override
	public void run() {
	}

	public MyRunnable(Integer fromIndex, List list) {
		super();
		this.list = list;
		this.fromIndex = fromIndex;
	}

}
