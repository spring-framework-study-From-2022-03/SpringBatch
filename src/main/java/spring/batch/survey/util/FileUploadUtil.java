package spring.batch.survey.util;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class FileUploadUtil {

    /**파일명 중복인 경우 파일명 변경하기*/
    public static String getUniqueFileName(String fileName) {

        //순수파일명만 추출 : ab
        int idx=fileName.lastIndexOf(".");
        String fName = fileName.substring(0, idx);

        //확장자 구하기 : .txt
        String ext = fileName.substring(idx);

        String time=getTimeStamp();
        String result = fName+"_"+time+ext;
        log.info("변경된 파일명={}", result);

        return result;
    }

    /** 밀리초 구하기*/
    private static String getTimeStamp() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String str = sdf.format(date);
        log.debug("current time={}",str);

        return str;
    }

}
