package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import repository.FreeDao;

public class FreeListService implements FreeService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		FreeDao dao = FreeDao.getInstance();
		
		// request에 필요한 정보 저장하기
		request.setAttribute("frees", FreeDao.getInstance().selectAllFrees());

		
		// BoardProject/list.jsp로 포워딩
		return new ActionForward("/list.jsp", false);
	}

}
