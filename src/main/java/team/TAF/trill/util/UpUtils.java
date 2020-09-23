package team.TAF.trill.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;


public class UpUtils {

    public static String upfile(MultipartFile file, HttpServletRequest request) {
        //判断文件后缀
        //file.getOriginalFilename().endsWith("");

        String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/video/");
        System.out.println(realPath);
        //String basePath="/Users/xiyang/IdeaProjects/trill/src/main/webapp/WEB-INF/video/";

        File file1 = new File(realPath);

        if (!file1.exists()) {
            file1.mkdirs();
        }
//        File file2 = new File(basePath);
//        if(!file2.exists()) {
//            file2.mkdirs();
//        }

        String orgName = file.getOriginalFilename();
        try {
            //http://localhost:8080/trill/video/
            FileOutputStream fos = new FileOutputStream(realPath+orgName,true);
            fos.write(file.getBytes());
            fos.flush();
            fos.close();
            return "200";

//            FileOutputStream fos1 = new FileOutputStream(basePath+orgName,true);
//            fos1.write(file.getBytes());
//            fos1.close();
//            fos1.flush();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "error";
    }

}
