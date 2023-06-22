package com.sp.app.domain.product;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<List<Long>> list = new ArrayList<>();
		List<Long> list1 = new ArrayList<>();
		list1.add(1L);
		list1.add(2L);
		list1.add(3L);

		List<Long> list2 = new ArrayList<>();
		list2.add(4L);
		list2.add(5L);
		list2.add(6L);

		List<Long> list3 = new ArrayList<>();
		list3.add(7L);
		list3.add(8L);
		list3.add(9L);

		list.add(list1);
		list.add(list2);
		list.add(list3);

//		List<List<Long>> lists = combineSubOptions(list);

//		for (List<Long> longs : lists) {
//			System.out.println(longs);
//		}

	}

}
