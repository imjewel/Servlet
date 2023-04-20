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

@WebServlet("/RM")
public class RegisterMember extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 폼페이지 이동
		String url = "member/registerMember.jsp";
		
		// 회원 번호 자동생성
		StudentDAO mdao = StudentDAO.getInstance();
		int nextNumber = mdao.currentNumber();
		
		request.setAttribute("nextNumber", nextNumber);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 폼으로 부터 입력받은 데이터를 처리
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

		StudentDAO mdao = StudentDAO.getInstance();
		mdao.insertMember(mDto);
		
		response.sendRedirect("registerSuccess.jsp");
	}

}
