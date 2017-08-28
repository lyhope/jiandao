package com.wwhm.jiandao.sakura;

import java.util.ArrayList;
import java.util.List;

public class SakuraData {

	// static String man[] = { "黄地", "史丹妮", "叶明磊", "祝俊", "洪博锴", "余颜辉", "张航" };

	public static List<String> createSakura(int count) {
		List<String> jiandaoSort = new ArrayList<>(25); // 一般集合
		List<String> jiandaoSortEspecially = new ArrayList<>(5); // 特殊集合
		List<String> jiandaoSortSum = new ArrayList<>(30);// 总集合
		// int count = sakura.length;
		// 1 计算 特别的 顺序
		// 1.1 总人数-3 算出 倒数第二个人 即 最开始的位为数
		int startEspeciallyindex = count - 2;
		for (int i = startEspeciallyindex; i - 2 >= -2; i = i - 2) {
			// jiandaoSortEspecially.add(sakura[i] + "-" +
			// sakura[(startEspeciallyindex + 1)]); // 添加到特殊
			jiandaoSortEspecially.add(i + "-" + (startEspeciallyindex + 1)); // 添加到特殊
			// System.out.println(i+""+(startEspeciallyindex+1));
		}
		// 2 正常的顺序
		for (int i = 1; i < count; i += 2) {
			// count -1 两个一起添加

			for (int j = 0; j < count - i - 1; j++) {
				int behind = j + i;
				// if (j == 0) { //如果是一开始 那么就赋i值
				// behind = i;
				// }
				// String one = sakura[j] + "-" + sakura[behind];
				String one = j + "-" + behind;
				jiandaoSort.add(one);
				// System.out.print(one + " ");
				if (j + 1 < count - i) {
					// String two = sakura[j] + "-" + sakura[(behind + 1)];
					String two = j + "-" + (behind + 1);
					jiandaoSort.add(two);
					// System.out.print(two);
				}
				// System.out.println();
			}
		}

		// 3 拼接成为总的顺序
		// 3.1 先判断特殊是单复数
		int especiallyCount = jiandaoSortEspecially.size();
		String endEspecially = "";
		if (especiallyCount % 2 == 1) { // 单数
			// 取出特殊集合里面最后一个 移除 找地方添加
			endEspecially = jiandaoSortEspecially.remove(especiallyCount - 1);
		}
		// 添加特殊的
		for (int i = 0; i < jiandaoSortEspecially.size(); i += 2) {
			jiandaoSortSum.add(jiandaoSortEspecially.get(i));
			jiandaoSortSum.add(jiandaoSortEspecially.get(i + 1));
			jiandaoSortSum.add(jiandaoSort.get(i));
			jiandaoSortSum.add(jiandaoSort.get(i + 1));
		}
		// // 添加一般的
		for (int i = jiandaoSortEspecially.size(); i < jiandaoSort.size(); i++) {
			// 判断添加特殊的最后一个
			if (!endEspecially.equals("")) {
				String[] splitOne = jiandaoSort.get(i).split("-");
				String[] splitTwo = endEspecially.split("-");
				// System.out.println(splitOne[0] + splitTwo[0]);
				if (!splitOne[0].equals(splitTwo[0])) {
					jiandaoSortSum.add(jiandaoSort.get(i));
					jiandaoSortSum.add(endEspecially);
					endEspecially = "";
					continue;
				}
			}
			jiandaoSortSum.add(jiandaoSort.get(i));
		}

		// // 判断添加特殊的最后一个
		// if (!endEspecially.equals("")) {
		// jiandaoSortSum.add(endEspecially);
		// }

		// 4 显示所有
		// for (int i = 0; i < jiandaoSortSum.size(); i += 2) {
		// System.out.print(jiandaoSortSum.get(i) + " ");
		// if (i + 1 < jiandaoSortSum.size()) {
		// System.out.println(jiandaoSortSum.get(i + 1));
		// }
		// }

		return jiandaoSortSum;
	}

}
