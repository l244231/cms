package com.cms.web.market.controller;

import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.cms.core.common.entity.BaseParams;
import com.cms.core.market.action.domain.AudiovisualDomain;
import com.cms.core.market.action.service.AudiovisualService;
import com.cms.web.common.controller.BaseController;
import com.cms.web.common.entity.PageVo;

/**
 * 
 * @Title:每日视听管理
 * @Author:lijx
 * @Version:1.0
 * @Created:2016年12月20日 上午12:00:52 lijx <br>
 * @History:
 */
@Controller
@RequestMapping("/market/audiovisual")
public class AudiovisualController extends BaseController {

	@Autowired
	protected AudiovisualService audiovisualService;

	@RequestMapping("page")
	public ModelAndView page(HttpServletRequest request, HttpServletResponse resopnse) {
		ModelAndView mav = new ModelAndView("cms/market/audiovisual/page");
		mav.addObject("isBack",request.getParameter("isBack"));
		return mav;
	}

	@RequestMapping("add")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse resopnse) {

		ModelAndView modelAndView = new ModelAndView("cms/market/audiovisual/form");
		modelAndView.addObject("isEdit", true);

		return modelAndView;
	}

	@RequestMapping("edit")
	public ModelAndView edit(HttpServletRequest request, HttpServletResponse resopnse) {

		ModelAndView modelAndView = new ModelAndView("cms/market/audiovisual/form");

		String id = request.getParameter("id");
		Map<String, Object> result = new HashMap<String, Object>();
		if (id != null && id != "") {
			result = audiovisualService.queryAvDetail(Long.parseLong(id));
		}
		modelAndView.addObject("isEdit", true);
		modelAndView.addObject("result", result);

		return modelAndView;
	}

	/**
	 * @Title:detail
	 * @Author:Zain.Luo
	 * @Description:进入编辑页面
	 * @param request
	 * @param resopnse
	 * @return
	 * @Created:2017年1月4日 上午12:45:51<br>
	 * @History:
	 */
	@RequestMapping("detail")
	public ModelAndView detail(HttpServletRequest request, HttpServletResponse resopnse) {

		ModelAndView modelAndView = new ModelAndView("cms/market/audiovisual/detail");

		long id = Long.parseLong(request.getParameter("id"));
		Map<String, Object> result = audiovisualService.queryAvDetail(id);
		modelAndView.addObject("id", id);
		modelAndView.addObject("result", result);
		return modelAndView;
	}

	/**
	 * @Title:search
	 * @Author:Zain.Luo
	 * @Description:每日视听数据查询
	 * @param request
	 * @param response
	 * @param vo
	 * @Created:2017年1月3日 下午10:33:51<br>
	 * @History:
	 */
	@RequestMapping("search")
	public void search(HttpServletRequest request, HttpServletResponse response, PageVo vo, BaseParams bParams) {
		Map<String, Object> params = convertToPageParams(vo);
		params.put("title", decodeStr(bParams.getKeyWord()));
		params.put("type", bParams.getType());
		params.put("isHome", bParams.getIsHome());
		writeJson(getPageMap(audiovisualService.findListByPage(params)), response);
	}

	/**
	 * @Title:recommendAudiovisual
	 * @Author:Zain.Luo
	 * @Description:将数据推荐至首页
	 * @param request
	 * @param response
	 * @Created:2017年1月3日 下午10:34:40<br>
	 * @History:
	 */
	@RequestMapping("recommendAudiovisual")
	public void recommendAudiovisual(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		if (id == null || id == "") {
			returnOperationResult("N", "数据异常，请刷新后重试或联系管理员！");
		}
		String isHome = request.getParameter("param");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("isHome", isHome);

		if (isHome.equals("1")) {
			long count = audiovisualService.countByParams(params);
			if (count > 0) {
				returnOperationResult("N", "已存在推荐到首页的视听信息，请取消后再进行该操作");
				return;
			}
		}
		params.put("id", id);

		if (audiovisualService.recommendAudiovisual(params)) {
			returnOperationResult("Y", "操作成功");
		} else {
			returnOperationResult("N", "操作失败，请刷新后重试");
		}
	}

	/**
	 * @Title:delete
	 * @Author:Zain.Luo
	 * @Description:每日视听逻辑删除
	 * @param request
	 * @param response
	 * @Created:2017年1月3日 下午11:06:16<br>
	 * @History:
	 */
	@RequestMapping("delete")
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		if (id == null || id == "") {
			returnOperationResult("N", "数据异常，请刷新后重试或联系管理员！");
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);

		if (audiovisualService.delete(Long.parseLong(id))) {
			returnOperationResult("Y", "删除成功");
		} else {
			returnOperationResult("N", "删除失败，请刷新后重试");
		}
	}

	/**
	 * @Title: save
	 * @author: Zain.Luo
	 * @Description: 保存
	 * @param request
	 * @param response
	 * @param domain
	 * @return void
	 * @throws @history:
	 *             2017年1月5日 created
	 */
	@RequestMapping("save")
	public void save(HttpServletRequest request, HttpServletResponse response, AudiovisualDomain domain) {

		try {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			MultipartFile imgFile = multipartRequest.getFile("imgFile");
			MultipartFile mediaFile = multipartRequest.getFile("videoFile");

			String result = audiovisualService.save(imgFile, mediaFile, domain);
			if (result == null) {
				returnOperationResult("Y", "操作成功");
			} else {
				returnOperationResult("N", result);
			}
		} catch (Exception e) {
			returnOperationResult("N", e.getMessage());
		}
	}

	/**
	 * @Title: setStatus
	 * @author: Zain.Luo
	 * @Description: 修改状态
	 * @param request
	 * @param response
	 * @return void
	 * @throws @history:
	 *             2017年1月5日 created
	 */
	@RequestMapping("setStatus")
	public void setStatus(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String status = request.getParameter("status");
		if (id == null || id == "") {
			returnOperationResult("N", "操作失败，请刷新后重试");
			return;
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		params.put("status", status);
		audiovisualService.setStatus(params);
		returnOperationResult("Y", "操作成功");
	}
	
	@RequestMapping("/testInf")
	public void testInf(HttpServletRequest request, HttpServletResponse response){
		
		String url = "https://www.corporatetravel.ctrip.com/corpservice/authorize/ticket";
		String param = "{\"appKey\":\"obk_FDBX\",\"appSecurity\":\"obk_FDBX\"}";
		OutputStreamWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			HttpURLConnection conn = null;
			conn = (HttpURLConnection) realUrl.openConnection();// 打开和URL之间的连接
			// 发送POST请求必须设置如下两行
			conn.setRequestMethod("POST"); // POST方法
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.connect();
			out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");// 获取URLConnection对象对应的输出流
			out.write(param);// 发送请求参数
			out.flush();// flush输出流的缓冲
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));// 定义BufferedReader输入流来读取URL的响应
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
				System.out.println("OK");
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		System.out.println(result);
	}
}
