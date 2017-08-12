package cn.dlx.ssm.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.dlx.ssm.pojo.EasyUIResult;
import cn.dlx.ssm.pojo.User;
import cn.dlx.ssm.service.UserService;

@RequestMapping("user")
@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "page/{name}")
	public String toUsers(@PathVariable("name") String name) {
		return name;
	}

	@RequestMapping("list")
	@ResponseBody
	public EasyUIResult queryUserByPage(@RequestParam("page") String pageNum, @RequestParam("rows") String pageSize) {
		EasyUIResult easyUIResult = userService.queryUserByPage(pageNum, pageSize);
		return easyUIResult;
	}

	@RequestMapping("queryUserById")
	public String queryUserByIdOpenNew(@RequestParam("id") String id, Model model) {
		User user = userService.queryUserById(id);
		model.addAttribute("user", user);
		return "user-add";
	}

	@RequestMapping("save")
	@ResponseBody
	public Map<String, Object> saveUser(User user) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer num = userService.saveUser(user);
		if (num == 1) {
			map.put("status", "200");
		} else {
			map.put("status", "500");
		}
		return map;
	}

	@RequestMapping("delete")
	@ResponseBody
	public Map<String, Object> DeleteBatchUser(@RequestParam("ids") String[] ids) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			userService.deleteBatchUser(ids);
			map.put("status", "200");
			return map;
		} catch (Exception e) {
			map.put("status", "500");
			return map;
		}
	}

	@RequestMapping("update")
	@ResponseBody
	public Map<String, Object> updateUser(@RequestParam("id") String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Integer num = userService.updateUser(id);
			if (num == 1) {
				map.put("status", "200");
			} else {
				map.put("status", "500");
			}
			return map;
		} catch (Exception e) {
			map.put("status", "500");
			return map;
		}
	}

	@RequestMapping("export/excel")
	public String exportExcel(@RequestParam("page") String page, @RequestParam("rows") String rows, Model model) {
		EasyUIResult easyUIResult = this.userService.queryUserByPage(page, rows);
		model.addAttribute("userList", easyUIResult.getRows());
		return "excelView";
	}

}
