package com.emp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.bean.Emp;
import com.emp.dao.SqlQueries;

/**
 * Servlet implementation class homeSrv
 */
@WebServlet("/homeSrv")
public class homeSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public homeSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opr = request.getParameter("opr");
		PrintWriter pw = response.getWriter();
		if(opr.equals("insert"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String city = request.getParameter("city");
			int salary = Integer.parseInt(request.getParameter("salary"));
			String mobile = request.getParameter("mobile");

			Emp ob = new Emp();
			ob.setId(id);
			ob.setName(name);
			ob.setCity(city);
			ob.setSal(salary);
			ob.setMobile(mobile);
			
			int status = SqlQueries.insertData(ob);
			
			if(salary !=0)
			{
				pw.write("<script>alert('Data inserted');window.location.replace('index.html')</script>");
			}
			else
			{
				pw.write("<script>alert('Something went wrong');window.location.replace('index.html')</script>");
			}
		}
		else if(opr.equals("dataFetch"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("dataFetch.jsp");
			rd.include(request, response);
		}
		else if(opr.equals("delRequest"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("delete.jsp");
			rd.include(request, response);
		}
		else if(opr.equals("deleteId"))
		{
			int id = Integer.parseInt(request.getParameter("id"));

			int status = SqlQueries.deleteId(id);
			if(status !=0)
			{
				pw.write("<script>alert('Data Deleted');</script>");
				RequestDispatcher rd = request.getRequestDispatcher("delete.jsp");
				rd.include(request, response);
			}
			else
			{
				pw.write("<script>alert('Data not Deleted');</script>");
				RequestDispatcher rd = request.getRequestDispatcher("delete.jsp");
				rd.include(request, response);
			}
		}
		else if(opr.equals("updateRequest"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
			rd.include(request, response);
		}
		else if(opr.equals("updateId"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("updateForm.jsp");
			rd.include(request, response);
		}
		else if(opr.equals("updateData"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String city = request.getParameter("city");
			int salary = Integer.parseInt(request.getParameter("salary"));
			String mobile = request.getParameter("mobile");
			
			Emp ob = new Emp();
			ob.setId(id);
			ob.setName(name);
			ob.setCity(city);
			ob.setSal(salary);
			ob.setMobile(mobile);
			
			int status = SqlQueries.updateData(ob);
			
			if(status!=0)
			{
				pw.write("<script>alert('Data Updated');</script>");
				RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
				rd.include(request, response);
			}
			else
			{
				pw.write("<script>alert('Data not Updated');</script>");
				RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
				rd.include(request, response);
			}
		}
		else if(opr.equals("search"))
		{
			String name = request.getParameter("name");
			List<Emp> al = SqlQueries.searchName(name);
			if(!al.isEmpty())
			{
				RequestDispatcher rd = request.getRequestDispatcher("searchResult.jsp");
				rd.include(request, response); 
			}
			else
			{
				pw.write("<script>alert('No Data Found.');</script>");
				RequestDispatcher rd = request.getRequestDispatcher("index.html");
				rd.include(request, response);
			}
		}
		
	}

}
