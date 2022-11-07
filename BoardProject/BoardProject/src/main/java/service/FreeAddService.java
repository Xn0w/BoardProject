package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.Free;
import repository.FreeDao;

public class FreeAddService implements FreeService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 요청 파라미터
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		// DB로 보내기 위해 Free Free 생성
		Free free = new Free();
		free.setWriter(writer);
		free.setTitle(title);
		free.setContent(content);
		
		// DB로 Free Free 보내기(삽입)
		int result = FreeDao.getInstance().insertFree(free);
		
		// 삽입 성공 / 실패
		PrintWriter out = response.getWriter();
		if(result > 0) {
			out.println("<script>");
			out.println("alert('게시글이 등록되었습니다.')");
			out.println("location.href='" + request.getContextPath() + "/list.do'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('게시글 등록이 실패했습니다.')");
			out.println("history.back()");  // history.go(-1)
			out.println("</script>");
		}
		out.close();		
		
		return null;  // Java 문법 때문에 남겨둔 코드(실행되지 않는 코드)
		
	}

}