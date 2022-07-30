package cn.itcast.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

public class FileUtils {
	
	public static String upload(MultipartFile photo) throws IllegalStateException, IOException {
		String filepath="";
		String originalFilename="";
		String uuid="";
		if(!photo.isEmpty()) {
			String realPath = "E:\\image\\";
			originalFilename = photo.getOriginalFilename();
			uuid = UUID.randomUUID().toString().replace("-", "");
			
			if(originalFilename.endsWith("png") || originalFilename.endsWith("jpg")) {
				File file = new File(realPath+"/"+uuid+originalFilename);
				photo.transferTo(file);
			}
		}
		filepath = "E:\\image\\"+uuid+originalFilename;
		return filepath;
	}
	
	public static void getImagesId(String filePath, HttpServletResponse rp) {
        File imageFile = new File(filePath);
        if (imageFile.exists()) {
            FileInputStream fis = null;
            OutputStream os = null;
            try {
                fis = new FileInputStream(imageFile);
                os = rp.getOutputStream();
                int count = 0;
                byte[] buffer = new byte[1024 * 8];
                while ((count = fis.read(buffer)) != -1) {
                    os.write(buffer, 0, count);
                    os.flush();
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    fis.close();
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
