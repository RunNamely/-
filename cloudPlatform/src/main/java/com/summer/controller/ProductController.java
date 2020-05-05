package com.summer.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.summer.pojo.Product;
import com.summer.pojo.User;
import com.summer.service.IProductService;
import com.summer.utils.Fileutils;

@RestController
public class ProductController {

	@Autowired
	private IProductService productService;
	@Value("${web.upload-path}")
	private String path;
	@Autowired
	private HttpSession session;

	// order-status.html
	@RequestMapping(value = "/orderStatus", method = RequestMethod.GET)
	public ModelAndView order() {
		ModelAndView mv = new ModelAndView();
		int weijie = productService.countOrder(10);
		int yijie = productService.countOrder(20);
		int jujue = productService.countOrder(30);
		int shengchan = productService.countOrder(40);
		int wancheng = productService.countOrder(50);
		mv.addObject("weijie", weijie);
		mv.addObject("yijie", yijie);
		mv.addObject("jujue", jujue);
		mv.addObject("shengchan", shengchan);
		mv.addObject("wancheng", wancheng);
		mv.setViewName("order-status");
		return mv;
	}

	// 按条件查找页面
	@RequestMapping(value = "/seleProduct", method = RequestMethod.GET)
	public ModelAndView list(Product product) {
		String userName = (String) session.getAttribute("uName");
		User user = productService.selectUserByUserName(userName);
		product.setCreateUserid(user.getId());
		List<Product> findProduct = productService.findProduct(product);
		int findProductsize = findProduct.size();
		ModelAndView mv = new ModelAndView();
		mv.addObject("findProduct", findProduct);
		mv.addObject("findProductsize", findProductsize);
		mv.setViewName("product-list");
		return mv;
	}

	// 跳转到添加产品页面
	@RequestMapping(value = "/productadd", method = RequestMethod.GET)
	public ModelAndView productadd() {
		ModelAndView mv = new ModelAndView();
		String userName = (String) session.getAttribute("uName");
		User user = productService.selectUserByUserName(userName);
		if (user.getId() != null) {
			mv.addObject("createUserid", user.getId());
			mv.addObject("factoryId", user.getFactoryId());
		}
		mv.setViewName("product-add");
		return mv;
	}

	// 跳转到产品显示主页面
	@RequestMapping(value = "/productlist", method = RequestMethod.GET)
	public ModelAndView productlist() {
		String userName = (String) session.getAttribute("uName");
		User user = productService.selectUserByUserName(userName);
		Product product = new Product();
		product.setCreateUserid(user.getId());
		List<Product> findProduct = productService.findProduct(product);
		int findProductsize = findProduct.size();
		ModelAndView mv = new ModelAndView();
		mv.addObject("findProduct", findProduct);
		mv.addObject("findProductsize", findProductsize);
		mv.setViewName("product-list");
		return mv;
	}

	// 添加产品
	@RequestMapping(value = "/AddProduct", method = RequestMethod.POST)
	public ModelAndView add(Product product, @RequestParam("picture") MultipartFile file) {
		ModelAndView mv = new ModelAndView();
		// 获取文件名字
		String fileName = file.getOriginalFilename();
		// 获取改文件的上传路径
		String realPath = path + fileName;
		product.setProductImgUrl(realPath);
		// 文件上传
		boolean upload = Fileutils.upload(file, fileName);
		if (product.getProductNum() == "" || product.getProductName() == "" || product.getCreateUserid() == null
				|| product.getFactoryId() == null || product.getProductImgUrl() == "") {
			String str = "添加失败，请将所录入的产品信息填完整。";
			mv.addObject("msg", str);
		} else {
			productService.addProduct(product);
			String str = "添加成功";
			mv.addObject("msg", str);
		}
		String userName = (String) session.getAttribute("uName");
		User user = productService.selectUserByUserName(userName);
		if (user.getId() != null) {
			mv.addObject("createUserid", user.getId());
			mv.addObject("factoryId", user.getFactoryId());
		}
		mv.setViewName("product-add");
		return mv;
	}

	// 跳转到更新产品页面
	@GetMapping(value = "/ProductUpdate")
	public ModelAndView productupdate(@RequestParam(value = "id") int id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", id);
		String userName = (String) session.getAttribute("uName");
		User user = productService.selectUserByUserName(userName);
		if (user.getId() != null) {
			mv.addObject("userId", user.getId());
			mv.addObject("factoryId", user.getFactoryId());
		}
		mv.setViewName("product-update");
		return mv;
	}

	// 更新产品
	@RequestMapping(value = "/UpdateProduct", method = RequestMethod.POST)
	public ModelAndView update(Product product, @RequestParam("picture") MultipartFile file) {
		ModelAndView mv = new ModelAndView();
		System.out.println(product);
		// 获取文件名字
		String fileName = file.getOriginalFilename();
		// 获取改文件的上传路径
		String realPath = path + fileName;
		product.setProductImgUrl(realPath);
		// 文件上传
		boolean upload = Fileutils.upload(file, fileName);
		if (product.getProductNum() == "" || product.getProductName() == "" || product.getUpdateUserid() == null
				|| product.getFactoryId() == null || product.getProductImgUrl() == "") {
			mv.addObject("id", product.getId());
			String str = "修改失败，请将修改产品信息填完整。";
			mv.addObject("msg", str);
		} else {
			mv.addObject("id", product.getId());
			productService.updateProduct(product);
			String str = "修改成功";
			mv.addObject("msg", str);
		}
		String userName = (String) session.getAttribute("uName");
		User user = productService.selectUserByUserName(userName);
		if (user.getId() != null) {
			mv.addObject("userId", user.getId());
			mv.addObject("factoryId", user.getFactoryId());
		}
		mv.setViewName("product-update");
		return mv;
	}

	// 单个删除
	@GetMapping(value = "/ProductRemove")
	public ModelAndView remove(@RequestParam(value = "id") int id) {
		// 删除
		productService.removeProduct(id);
		ModelAndView mv = new ModelAndView();
		String userName = (String) session.getAttribute("uName");
		User user = productService.selectUserByUserName(userName);
		Product product = new Product();
		product.setCreateUserid(user.getId());
		List<Product> findProduct = productService.findProduct(product);
		int findProductsize = findProduct.size();
		// 传数据
		mv.addObject("findProduct", findProduct);
		mv.addObject("findProductsize", findProductsize);
		// 跳转页面
		mv.setViewName("product-list");
		return mv;
	}

	// 批量删除
	@RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
	public ModelAndView deleteProduct(String checkedID) {
		String[] split = checkedID.split(",");
		List<String> list = Arrays.asList(split);
		productService.deleteProduct(list);
		ModelAndView mv = new ModelAndView();
		String userName = (String) session.getAttribute("uName");
		User user = productService.selectUserByUserName(userName);
		Product product = new Product();
		product.setCreateUserid(user.getId());
		List<Product> findProduct = productService.findProduct(product);
		int findProductsize = findProduct.size();
		mv.addObject("findProduct", findProduct);
		mv.addObject("findProductsize", findProductsize);
		mv.setViewName("product-list");
		return mv;
	}
}
