package com.mg.utils;

import java.util.UUID;

/**
 * 随机产生激活码
 * @author sky_mg
 * 2017年6月11日上午11:44:47
 * TODO
 */
public class UUIDUtils {
	public static String getUUID() {
	return	UUID.randomUUID().toString().replaceAll("-", "");
	}
}
