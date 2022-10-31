<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="model1.board.BoardDAO"%>
<%@ page import="model1.board.BoardDTO"%>

<%
	 BoardDAO dao=new BoardDAO();

	Map<String,Object> map=new HashMap<String,Object>();
	
	String searchField=request.getParameter("searchField");
	String searchWord=request.getParameter("searchWord");
	
	if(searchWord!=null)
	{
		map.put("searchField",searchField);
		map.put("searchWord",searchWord);
	}
	int totalCount=dao.selectCount(map);
	List<BoardDTO> boardLists=dao.selectList(map);
	dao.close();
	//수정해보기 수정수정
	

%>