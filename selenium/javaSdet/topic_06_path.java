package javaSdet;

import java.io.File;

public class topic_06_path {
    public static void main(String[]args){
        String projectPath=System.getProperty("user.dir");
        System.out.println(projectPath);

        String osName =System.getProperty("os.name");
        System.out.println(osName);

        String separator = File.separator;
        System.out.println(separator);

        String uploadFolderPath= System.getProperty("user.dir")+ File.separator +"uploadFiles"+File.separator;
        String hoiAn="HoiAn.jpg";
        String haGiang="HaGiang.jpg";
        String phuQuoc ="PhuQuoc.jpg";

        String hoiAnPath =uploadFolderPath +hoiAn;
        String haGiangPath =uploadFolderPath+haGiang;
        String phuQuocPath = uploadFolderPath+phuQuoc;

        System.out.println(hoiAnPath);
        System.out.println(haGiangPath);
        System.out.println(phuQuocPath);
    }
}
