package team.TAF.trill.controller;

import cn.dsna.util.images.ValidateCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import team.TAF.trill.dto.Result;
import team.TAF.trill.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping("/main")
    public String main()
    {
        return "index";
    }

    @RequestMapping("/main1")
    public String main1()
    {
        return "main";
    }

    @RequestMapping("/getCode")
    @ResponseBody
    public void getCode(HttpServletRequest request, HttpServletResponse response){
        ValidateCode validateCode = new ValidateCode(160, 40, 4, 50);
        String code = validateCode.getCode();
        request.getSession().setAttribute("code", code);

        try {
            validateCode.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/login")
    @ResponseBody
    public Result login(String username, String password, String code, HttpServletRequest request){
        return userService.login(username, password, code, request);
    }

    @RequestMapping("echarts")
    public String echarts(){
        return "echarts";
    }
}
