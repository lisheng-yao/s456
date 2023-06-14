package com.shop.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.shop.model.ShopCarouselService;
import com.shop.model.ShopCarouselVO;

@WebServlet("/ShopCarouselServlet")
public class ShopCarouselServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ShopCarouselService shopCarouselService;
	Gson gson = new Gson();

	public void init() {
		shopCarouselService = new ShopCarouselService();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 設定回應的內容類型為 text/html
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		

		List<ShopCarouselVO> list = shopCarouselService.getAll();

		out.write(gson.toJson(list));

		
//	================================== 新增資料 =============================================
		
		String contentType = request.getContentType();
		String dataTypeAction = request.getHeader("X-Data-Type");
        if ("json1".equals(dataTypeAction) && contentType != null && contentType.startsWith("application/json")) {
//        	String json="";
            // 讀取請求的 JSON 內容
            BufferedReader reader = request.getReader();
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            reader.close();

            // 解析 JSON 內容
            JsonObject json = gson.fromJson(sb.toString(), JsonObject.class);

            // 從解析後的 JSON 中獲取相應的屬性值
            String shopCarouselTitle = json.get("shopCarouselTitle").getAsString();
            String shopCarouselText = json.get("shopCarouselText").getAsString();
            // 將 Base64 字串轉換為二進位資料
            String base64Image = json.get("shopCarouselPic").getAsString();
            // Base64字串中移除資料類型的部分 data:image/jpeg;base64,/!!!
            base64Image = base64Image.substring(base64Image.indexOf(",") + 1);
            // System.out.println(base64Image);
            byte[] shopCarouselPic = Base64.getDecoder().decode(base64Image);
            Date shopCarouselStartTime = Date.valueOf(json.get("shopCarouselStartTime").getAsString());
            Date shopCarouselEndTime = Date.valueOf(json.get("shopCarouselEndTime").getAsString());
            Integer shopCarouselState = json.get("shopCarouselState").getAsInt();
            String shopCarouselUrl = json.get("shopCarouselUrl").getAsString();
            
            ShopCarouselService svc = new ShopCarouselService();
            svc.addCarousel(shopCarouselTitle,shopCarouselText,shopCarouselPic,shopCarouselStartTime,shopCarouselEndTime
            		,shopCarouselState,shopCarouselUrl);
            
            
        }
        
        // ========================================== 修改 ===================================================
        
        if (("json2".equals(dataTypeAction) && contentType != null && contentType.startsWith("application/json"))) {

        	BufferedReader reader = request.getReader();
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            reader.close();

            // 解析 JSON 內容
            JsonObject json = gson.fromJson(sb.toString(), JsonObject.class);
            //  System.out.println(json);

            // 從解析後的 JSON 中獲取相應的屬性值
            Integer shopCarouselNo = json.get("updateShopCarouselNo").getAsInt();
            String shopCarouselTitle = json.get("updateShopCarouselTitle").getAsString();
            String shopCarouselText = json.get("updateShopCarouselText").getAsString();
            // 將 Base64 字串轉換為二進位資料
            String base64Image = json.get("updateShopCarouselPic").getAsString();
            // Base64字串中移除資料類型的部分 data:image/jpeg;base64,/!!!
            base64Image = base64Image.substring(base64Image.indexOf(",") + 1);
            // System.out.println(base64Image);                        
            byte[] shopCarouselPic = Base64.getDecoder().decode(base64Image);
            Date shopCarouselStartTime = Date.valueOf(json.get("updateShopCarouselStartTime").getAsString());
            Date shopCarouselEndTime = Date.valueOf(json.get("updateShopCarouselEndTime").getAsString());
            Integer shopCarouselState = json.get("updateShopCarouselState").getAsInt();
            String shopCarouselUrl = json.get("updateShopCarouselUrl").getAsString();
            
            ShopCarouselService svc = new ShopCarouselService();
            svc.updateShopCarousel(shopCarouselNo,shopCarouselTitle,shopCarouselText,shopCarouselPic,shopCarouselStartTime,shopCarouselEndTime
            		,shopCarouselState,shopCarouselUrl);
        	
//        	svc.updateShopCarousel(shopCarouselTitle,shopCarouselText,shopCarouselPic,shopCarouselStartTime,shopCarouselEndTime
//            		,shopCarouselState,shopCarouselUrl);
        	
        }
        

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
        
	}
}