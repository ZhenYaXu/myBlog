package cn.xustars.myblog.utils;

import java.io.File;

/**
 * 文件操作类
 * 
 * 
 * @author an
 *
 */
public class FileUtil {
	/**
	 * 获得唯一文件名(不会重复) 当前文件所在位置
	 * 
	 * @param filePath
	 *            返回的文件名
	 * @param fileType
	 *            文件类型传入的值如:.mp4,.jpg等数据
	 * @return
	 */
	public static String getUniqueFileName(String filePath, String fileType) {
		String fileName = "";

		while (true) {
			fileName = DateUtils.getUniqueFileNameByTime();

			File file = new File(filePath + fileName + fileType);
			if (!file.exists()) {
				return fileName;
			}

		}

	}
}
