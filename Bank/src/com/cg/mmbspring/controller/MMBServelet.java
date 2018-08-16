package com.cg.mmbspring.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.mmbspring.pojo.BankAccount;
import com.cg.mmbspring.pojo.CurrentAccount;
import com.cg.mmbspring.pojo.Customer;
import com.cg.mmbspring.pojo.SavingAccount;
import com.cg.mmbspring.service.MMBSpringService;

/**
 * Servlet implementation class MMBServelet
 */
@WebServlet("*.mmb")
public class MMBServelet extends HttpServlet {
	Customer customer;
	SavingAccount savingsaccount;
	CurrentAccount currentaccount;
	BankAccount bankaccount;
	MMBSpringService service = new MMBSpringService();
	
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MMBServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		///response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd;
		String action = request.getServletPath();
		
		switch (action) {
		/*case "/viewAllAccount.mmb":
			Collection<BankAccount> bankAccount = service.viewAllAccount;
			request.setAttribute("bankAccount", bankAccount);
			rd=request.getRequestDispatcher("viewAll.jsp");
			rd.forward(request,response);
			
			break;*/
			
		case "/fundTransfer.mmb":
			rd=request.getRequestDispatcher("fundTransfer.jsp");
			rd.forward(request, response);
			break;
			
		case "/saeFundTransfer.mmb":
			int fromAccNo = Integer.parseInt(request.getParameter("fromAccNo"));
			int toAccNo = Integer.parseInt(request.getParameter("toAccNo"));
			int bal = Integer.parseInt(request.getParameter("amount"));
			int retrievedBalance = service.withdraw(fromAccNo, bal);
			if(retrievedBalance>=0) {
				int accBal = service.deposit(toAccNo, bal);
				if(accBal !=0) {
					request.setAttribute("retrive", retrievedBalance);
					request.setAttribute("accBal", accBal);
					request.setAttribute("from", fromAccNo);
					request.setAttribute("to", toAccNo);
					request.setAttribute("balTransfer", bal);
					rd=request.getRequestDispatcher("successFundTransfer.jsp");
					rd.forward(request, response);
				}else {
					response.sendRedirect("errorAccNotFound.jsp");
				}
			}else if(retrievedBalance==-2) 
				response.sendRedirect("errorAccNotFound.jsp");
				else if(retrievedBalance==-1)
					response.sendRedirect("insufficienBal.jsp");

			break;
		case "/withdraw.mmb":
			rd=request.getRequestDispatcher("withdraw.jsp");
			rd.forward(request, response);
			break;
			
		case "/deposit.mmb":
			rd=request.getRequestDispatcher("deposit.jsp");
			rd.forward(request, response);
			break;
			
		case "/saveDeposit.mmb":
			int accNo = Integer.parseInt(request.getParameter("accno"));
			int balance = Integer.parseInt(request.getParameter("amount"));
				int accBal = service.deposit(accNo, balance);
				if(accBal !=0) {
					request.setAttribute("accBal", accBal);
					request.setAttribute("accNo", accNo);
					rd=request.getRequestDispatcher("success.jsp");
					rd.forward(request, response);
				}else {
					response.sendRedirect("errorAccNotFound.jsp");
				}
				break;
				
		case "/saveWithdraw.mmb":
			int accNum = Integer.parseInt(request.getParameter("accno"));
			int accBalance = Integer.parseInt(request.getParameter("amount"));
				accBal = service.withdraw(accNum, accBalance);
				if(accBal >=0) {
					request.setAttribute("accBal", accBal);
					request.setAttribute("accNo", accNum);
					rd=request.getRequestDispatcher("success.jsp");
					rd.forward(request, response);
				}else if(accBal==-2) 
					response.sendRedirect("errorAccNotFound.jsp");
					else if(accBal==-1)
						response.sendRedirect("insufficienBal.jsp");
					
			break;
			
			default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
