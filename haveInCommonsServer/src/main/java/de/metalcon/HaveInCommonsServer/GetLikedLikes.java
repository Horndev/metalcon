package de.metalcon.HaveInCommonsServer;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.metalcon.HaveInCommonsServer.helper.*;

import org.apache.commons.lang.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class GetLikedLikes extends HttpServlet{


	private static final long serialVersionUID = -3346554840364724871L;
	
	JSONObject jsonObj;
	JSONArray jsonArr;
	String muid;
	int timestamp;
	int[] foo = {23, 42, 1024, 666};
		
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		muid = request.getParameter("muid");
		if(StringUtils.isNotBlank(request.getParameter("timestamp")))
			timestamp = Integer.parseInt(request.getParameter("timestamp"));
		else
			jsonObj.put("Error", ProtocolConstants.TIMESTAMP_NOT_GIVEN);
		if (muid == null)
			jsonObj.put("Error", ProtocolConstants.MUID_NOT_GIVEN);
		else if (muid.isEmpty())
			jsonObj.put("Error", ProtocolConstants.MUID_MALFORMED);
		else if (timestamp == 0)
			jsonObj.put("Error", ProtocolConstants.TIMESTAMP_INVALID);
		else {
			
			for(int val : foo) {
				jsonArr.add(val);
			}
			
			//TODO: API call goes here;
			//TODO: MUID validation;
			//TODO: Calling haveInCommonsService;
			
			jsonObj.put("muid", muid); //muid of requesting entity
			jsonObj.put("likes", jsonArr); //muid of liked entities from entities someone is connected by hop 2
		}
		response.setContentType("application/json");
		response(response, jsonObj.toJSONString());
	}
	
	private void response(HttpServletResponse resp, String msg)
			throws IOException {
		PrintWriter out = resp.getWriter();
		out.println(msg);
		out.close();
		
	}
}
