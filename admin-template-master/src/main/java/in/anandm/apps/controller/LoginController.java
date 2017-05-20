package in.anandm.apps.controller;

import in.anandm.apps.dto.GroupDto;
import in.anandm.apps.entity.ImFriend;
import in.anandm.apps.entity.ImUser;
import in.anandm.apps.service.RoomService;
import in.anandm.apps.service.UserService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Created by zyk on 2017/5/8.
 */
@Controller
@SessionAttributes(value = {"loginUser","gpList"})
@RequestMapping(value="/")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private RoomService roomService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String userLogin(@ModelAttribute("user") @Valid ImUser user, BindingResult br, ModelMap map) {
        if(br.hasErrors()){
            return "pages/examples/login";
        }

        String loginId = user.getLoginId();
        String password = user.getPassword();

        System.out.println("loginId: " + loginId +" password: " + password);
        String pwd = userService.getPasswordByLoginId(loginId);
        if(password.equals(pwd)) {
            ImUser loginUser = userService.getUserByLoginId(loginId);
            map.addAttribute("loginUser",loginUser);
            return "redirect:getAllGroups?userLoginId="+loginId;
        }
        else {
            map.addAttribute("message","密码错误");
            return "pages/examples/login";
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") @Valid ImUser user, BindingResult br, ModelMap map) {
        if(userService.register(user)){
            return "pages/examples/login";
        }
        else {
            return "pages/examples/register";
        }
    }

    @RequestMapping(value = "/getFriendList", method = RequestMethod.GET)
    public  String getFriendList(String groupId,Map<String,Object> map){
        List<ImFriend> list = userService.getFriendList(groupId);
        map.put("fdList",list);
        return "pages/examples/blank";
    }

    @RequestMapping(value = "/getAllGroups", method = RequestMethod.GET)
    public  String getAllGroups(String userLoginId,Map<String,Object> map){
        List<GroupDto> list = userService.getGroupList(userLoginId);
        map.put("gpList",list);
        return "pages/examples/blank";
    }

    @RequestMapping(value = "/SingleChatRoom",method = RequestMethod.GET)
    public String SingleChatRoom(HttpSession session,String otherId, Map<String,Object> map){
        ImUser other = userService.getUserByLoginId(otherId);
        ImUser self  = (ImUser) session.getAttribute("loginUser");
        roomService.createSingleRoom(other.getNickname(),self.getNickname());
        logger.info("聊天室创建------------"+other.getNickname());
        System.out.println("聊天室创建------------"+other.getNickname());
        map.put("other",other);
        return "pages/examples/chat2";
    }
    @RequestMapping(value = "/searchUser",method = RequestMethod.GET)
    public @ResponseBody String serachUser(String loginId){
        logger.info(loginId);
        ImUser user = userService.getUserByLoginId(loginId);
        JSONObject obj  = JSONObject.fromObject(user);
        logger.info(user.toString());
        System.out.println(obj.toString());
        return  obj.toString();
    }

    @RequestMapping(value = "/addFriend",method = RequestMethod.POST)
    public @ResponseBody String addFriend(String groupId, String fdId){
        ImUser friend = userService.getUserByLoginId(fdId);
        logger.info("friend="+friend.toString());
        userService.addFriend(groupId, friend);
        JSONObject json = new JSONObject();
        json.put("msg",friend.getNickname());
        logger.info(json.toString());
        return json.toString();
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public @ResponseBody String test(){

        return "{msg:123}";
    }
}
