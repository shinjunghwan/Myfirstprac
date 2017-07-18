package mybatis;

import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.domain.MemberDTO;

import java.io.IOException;
import java.io.Reader;
import java.sql.*;

public class MemberDAO {
	private static SqlSessionFactory sqlSessionFactory;
	static {
		try {
			String resource = "resources/mybatis/config-mybatis.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public MemberDAO() {
		
	}
	
	public List<MemberDTO> select() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		try {
			list = sqlSession.selectList("org.mybatis.persistence.Membermanage.list");
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}
		return list;
	}
	
	public void insert(String name, String age, String height, String weight, String sex) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			MemberDTO member = new MemberDTO();
			member.setName(name);
			member.setAge(Integer.parseInt(age));
			member.setHeight(Integer.parseInt(height));
			member.setWeight(Integer.parseInt(weight));
			member.setSex(sex.charAt(0));
			sqlSession.insert("org.mybatis.persistence.Membermanage.insert",member);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}
	}

	public void delete(String name) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			MemberDTO member = new MemberDTO();
			member.setName(name);
			sqlSession.delete("org.mybatis.persistence.Membermanage.delete",member);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}
	}

	public void update(String name, String age, String height, String weight, String sex) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			MemberDTO member = new MemberDTO();
			member.setName(name);
			member.setAge(Integer.parseInt(age));
			member.setHeight(Integer.parseInt(height));
			member.setWeight(Integer.parseInt(weight));
			member.setSex(sex.charAt(0));
			sqlSession.update("org.mybatis.persistence.Membermanage.update", member);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}
	}
	
	public MemberDTO search(String name) throws RecordNotFoundException {
		if(!isExist(name)) throw new RecordNotFoundException("찾는 레코드가 없음");
	
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MemberDTO member = new MemberDTO();
		try {
			
			member.setName(name);
			member = sqlSession.selectOne("org.mybatis.persistence.Membermanage.select", member);
			
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}
		return member;
	}

	public boolean isExist(String name) {
		boolean result = false;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			MemberDTO member = new MemberDTO();
			member.setName(name);
			member = sqlSession.selectOne("org.mybatis.persistence.Membermanage.select", member);
			if(member.getAge() != 0) result = true;
		} catch (Exception e) {
			
			e.printStackTrace();
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}
		return result;
	}

}
