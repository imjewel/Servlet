package controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;
import dto.MemberDTO;


@WebServlet("/UM")
public class UpdateMember extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 수정 폼으로 이동
		int studno = Integer.parseInt(request.getParameter("studno"));
		
		StudentDAO mDao = StudentDAO.getInstance();
	    MemberDTO mDto = mDao.selectTargetMember(studno);
	    
	    request.setAttribute("member", mDto);
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher("member/updateMember.jsp");
	    dispatcher.forward(request, response);
	    
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 수정된 데이터 반영
		request.setCharacterEncoding("utf-8");
		
		int studno = Integer.parseInt(request.getParameter("studno"));
		String studname = request.getParameter("studname");
		int korean = Integer.parseInt(request.getParameter("korean"));
		int english = Integer.parseInt(request.getParameter("english"));
		int math = Integer.parseInt(request.getParameter("math"));
		int history = Integer.parseInt(request.getParameter("history"));

		
		
		MemberDTO mDto = new MemberDTO();
		mDto.setStudno(studno);
		mDto.setStudname(studname);
		mDto.setKorean(korean);
		mDto.setEnglish(english);
		mDto.setMath(math);
		mDto.setHistory(history);
		
		StudentDAO mDao = StudentDAO.getInstance();
		mDao.updateMember(mDto);
		
		response.sendRedirect("updateSuccess.jsp");
		
		
		
		
		
		
	}

}
