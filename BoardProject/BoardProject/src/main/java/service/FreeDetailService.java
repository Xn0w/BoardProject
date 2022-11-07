package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import repository.FreeDao;

public class FreeDetailService implements FreeService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		FreeDao dao = FreeDao.getInstance();
		
		// request에 필요한 정보 저장하기
		request.setAttribute("students", dao.selectAllFrees());
		
		// student/list.jsp로 포워딩
		return new ActionForward("/BoardProject/list.jsp", false);
	}

}
