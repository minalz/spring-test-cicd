package cn.minalz.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 格式控制器
 * @author minalz
 * @since 2024/03/01 11:36:20
 */
@RestController
public class FormatController {

    @GetMapping("/format")
    public String format() {
        return "helloFormatTemplate.doFormat(user)";
    }
}
