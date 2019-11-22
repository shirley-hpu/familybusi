package com.sitech.family.common;

import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 读取json文件
 *
 * @author shirley
 * @date created in 2019/4/2
 */
@Component
public class JsonReader {

    //ClassPathResource resource = new ClassPathResource("detail.json");

    //@Value(value = "classpath:detail")
    //private Resource resource;

    public String parseJson(Resource resource) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            StringBuilder message = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                message.append(line);
            }

            String defaultString = message.toString();
            String result = defaultString.replace("\r\n", "").replaceAll(" +", "");
            //System.out.println(result);
            return result;
        } catch (Exception e) {
            throw new BusiException(resource.toString() + "文件读取失败");
        }

    }


}
