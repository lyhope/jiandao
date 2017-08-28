package com.wwhm.jiandao.sakura;

import java.util.ArrayList;
import java.util.List;

public class SakuraModel {
	// static int count = 10;
	// static String man[] = { "黄地", "史丹妮", "叶明磊", "祝俊", "洪博锴", "余颜辉", "张航",
	// "赵力", "卢泽珅","许泽雅","邹婧" };

//	static String man[] = { "黄地", "史丹妮", "叶明磊", "祝俊", "洪博锴", "余颜辉", "张航" };
	// static String man[] = { "黄地", "史丹妮", "叶明磊", "祝俊"};

	public static void main(String[] args) {
		// 生成排序
		List<String> createSakura = SakuraData.createSakura(20); //改数字

		createModelData(createSakura);

		// 生成html代码
		 List<String> createHtmlCode = createHtmlCode(createSakura);
		 //打印
//		 for (String string : createHtmlCode) {
//		 System.out.println(string);
//		 }

		// TODO 后期使用手点数据 解决这个问题
	}

	/**
	 * 创建默认模型
	 * 
	 * @param createSakura
	 */
	public static void createModelData(List<String> createSakura) {
		for (int i = 0; i < createSakura.size(); i += 2) {
//			System.out.print(createSakura.get(i) + "     ");
			if (i + 1 < createSakura.size()) {
				// 打印 1-1 x-x
//				System.out.println(createSakura.get(i + 1));
			}
		}
		for (String string : createSakura) {
			System.out.println("result.add(\"" + string + "\");");
		}

	}

//	// 生成排序
//	private static List<String> createSort() {
//		List<String> game = new ArrayList<String>(20);
//
//		// 生成次序
//		for (int i = 0; i < man.length; i++) {
//			for (int j = i + 1; j < man.length; j++) {
//				// game.add(man[j - i - 1] + "-" + man[j]); // 替换添加
//				// game.add((j - i - 1) + "对阵" + j); // 替换添加
//				System.out.print(i + "" + j + "   "); // 测试看数据
//			}
//			System.out.println(); // 测试看数据
//		}
//		return game;
//
//	}

	public static List<String> createHtmlCode(List<String> gameSort) {
		List<String> htmlCodeList = new ArrayList<>();
		// html 原字符串
		String htmlCode = "<tr><td>%nameRed</td>" + "<td>对阵</td>" + "<td>%nameWhite</td>" + "<td>%rate</td></tr>";

		for (int i = 0; i < gameSort.size(); i++) {
			String[] strArray = gameSort.get(i).split("-");
			String tempHtmlCode = htmlCode;
			tempHtmlCode = tempHtmlCode.replace("%nameRed", strArray[0]);
			tempHtmlCode = tempHtmlCode.replace("%nameWhite", strArray[1]);
			tempHtmlCode = tempHtmlCode.replace("%rate", (i + 1) + "/" + gameSort.size());
			htmlCodeList.add(tempHtmlCode);
		}

		return htmlCodeList;
	}

}
