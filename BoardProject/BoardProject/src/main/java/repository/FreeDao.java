package repository;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.Free;
import domain.Free;

public class FreeDao {

	// field - SqlSessionFactory
	private SqlSessionFactory factory;
	
	// singleton pattern
	private static FreeDao dao = new FreeDao();
	private FreeDao() {
		try {
			// SqlSessionFactory 빌드
			String resource = "mybatis/config/mybatis-config.xml";
			InputStream in = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static FreeDao getInstance() {
		return dao;
	}
	
	// method
	
	String mapper = "mybatis.mapper.free.";
	
	// 1. 게시글 목록
	public List<Free> selectAllFrees() {
		SqlSession ss = factory.openSession();
		List<Free> frees = ss.selectList(mapper + "selectAllFrees");
		ss.close();
		return frees;
	}
	
	// 2. 게시글 상세 보기
	public Free selectFreeByNo(int FreeNo) {
		SqlSession ss = factory.openSession();
		Free Free = ss.selectOne("mybatis.mapper.Free.selectFreeByNo", FreeNo);  // FreeNo를 파라미터로 전달
		ss.close();
		return Free;
	}
	
	// 3. 게시글 삽입
	public int insertFree(Free free) {
		SqlSession ss = factory.openSession(false);  // INSERT(커밋이 필요한 경우)
		int result = ss.insert("mybatis.mapper.free.insertFree", free);  // Free를 파라미터로 전달
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
}