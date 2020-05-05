package com.summer.utils;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class Fileutils {
	
	public static boolean upload(MultipartFile file,String fileName){
		String path = "D:/Working_work/cloudPlatform/src/main/resources/static/img/";
		// 文件			
		String realPath = path + "/" + fileName;
		File dest = new File(realPath);
		//判断文件父目录是否存在
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }
        try {
        	// 保存文件
			file.transferTo(dest);
			return true;
		} catch (IllegalStateException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
