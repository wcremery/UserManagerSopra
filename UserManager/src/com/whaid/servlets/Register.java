package com.whaid.servlets;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.whaid.beans.User;

@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String VIEW_PAGES_URL = "/WEB-INF/register.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String msgErrorEmail = "";
		String msgErrorPwd = "";
		String msgErrorName = "";
		String msgValidation = "";
		String valueEmail = "";
		String valueName = "";

		request.setAttribute("valueEmail", valueEmail);
		request.setAttribute("valueName", valueName);
		request.setAttribute("msgErrorEmail", msgErrorEmail);
		request.setAttribute("msgErrorPwd", msgErrorPwd);
		request.setAttribute("msgErrorName", msgErrorName);
		request.setAttribute("msgValidation", msgValidation);

		this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String pwd1 = request.getParameter("pwd1");
		String pwd2 = request.getParameter("pwd2");
		String name = request.getParameter("name");

		String msgErrorEmail = validateEmail(email);
		if (msgErrorEmail != null) {
			request.setAttribute("msgErrorEmail", msgErrorEmail);
		} else {
			request.setAttribute("valueEmail", email);
		}

		String msgErrorPwd = validatePwd(pwd1, pwd2);
		if (msgErrorPwd != null) {
			request.setAttribute("msgErrorPwd1", msgErrorPwd);
			request.setAttribute("msgErrorPwd2", msgErrorPwd);
		}

		String msgErrorName = validateName(name);
		if (msgErrorName != null) {
			request.setAttribute("msgErrorName", msgErrorName);
		} else {
			request.setAttribute("valueName", name);
		}

		String msgValidation = "";
		if (msgErrorEmail == null && msgErrorName == null && msgErrorPwd == null) {
			msgValidation = "Inscription réussie";
		} else {
			msgValidation = "Inscription impossible";
		}

		request.setAttribute("msgValidation", msgValidation);

		User newUser = null;
		boolean errorStatus = true;
		HashMap<String, String> errors = new HashMap<String, String>();
		String actionMessage;
		HashMap<String, String> form = new HashMap<String, String>();
		if (errors.isEmpty()) {
			newUser = new User(name, email, pwd1);
			actionMessage = "Succès de l'inscription";
			form = new HashMap<String, String>();
			errorStatus = false;
		} else {
			actionMessage = "Echec de l'inscription";
			errorStatus = true;
		}
		request.setAttribute("newUser", newUser);
		request.setAttribute("errorStatus", errorStatus);
		request.setAttribute("form", form);
		request.setAttribute("errors", errors);
		request.setAttribute("actionMessage", actionMessage);

		try {
			validateEmail(email);
			validatePwd(pwd1, pwd2);
			validateName(name);
		} catch (Exception e) {
			response.getWriter().println(e.getMessage());
			this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).include(request, response);
		}
	}

	private String validateEmail(String email) {
		return null;
	}

	private String validatePwd(String pwd1, String pwd2) {
		if (pwd1 == null || pwd1.length() < 3) {
			return ("mot de passe invalide");
		}
		return null;
	}

	private String validateName(String name) {
		return null;
	}

}