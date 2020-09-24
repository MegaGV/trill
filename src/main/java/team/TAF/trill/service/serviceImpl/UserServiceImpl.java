package team.TAF.trill.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.TAF.trill.dao.UserMapper;
import team.TAF.trill.dto.Result;
import team.TAF.trill.pojo.User;
import team.TAF.trill.service.UserService;
import team.TAF.trill.util.MD5Utils;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public Result login(String username, String password, String code, HttpServletRequest request) {
        Result result = new Result();
        username=username.trim();

        if (!code.equalsIgnoreCase((String) request.getSession().getAttribute("code"))){
            result.setStatus(400);
            result.setMessage("验证码错误");
        }
        else{
            User user = userMapper.getUserByUsername(username);
            if (user == null){
                result.setStatus(400);
                result.setMessage("用户不存在");
            }
            else{
                if (MD5Utils.md5Code(username, password).equals(user.getPassword())){
                    request.getSession().setAttribute("user", user);
                    result.setMessage("登录成功");
                }
                else{
                    result.setStatus(400);
                    result.setMessage("密码错误");
                }
            }
        }

        return result;
    }
}
