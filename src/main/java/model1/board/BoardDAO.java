package model1.board;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import common.DBConnPool;

public class BoardDAO extends DBConnPool{

	public int selectCount(Map<String,Object> map)
	{
		int totalCount=0;
		
		String query= "select count(*) from board";
		if(map.get("searchWord")!=null)
		{
			query+= " where "+map.get("searchField")+ "like '%" + map.get("searchWord") +"%'";
			
		}
	
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			rs.next();
			totalCount=rs.getInt(1);
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return totalCount;
	}
	
	public List<BoardDTO> selectList(Map<String,Object> map)
	{
		List<BoardDTO> bbs=new Vector<BoardDTO>();
		
		String query="Select * from board";
		
		if(map.get("searchWord")!=null)
		{
			query+="where "+map.get("searchField") +"like '%"+map.get("searchWord")+"%'";
		}
		query+="order by num desc";
		
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			
			while(rs.next())//한행의 내용을 DTO에 저장 
			{
				BoardDTO dto=new BoardDTO();
				dto.setNum(rs.getString("num"));
				dto.setContent(rs.getString("content"));
				dto.setTitle(rs.getString("title"));
				dto.setPostdate(rs.getDate("postdate"));
				dto.setId(rs.getString("id"));
				dto.setVisitcount(rs.getString("visitcount"));
				
				bbs.add(dto);
				
				
			}
		}catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return bbs;
	}
	
	
	
	
	
}
