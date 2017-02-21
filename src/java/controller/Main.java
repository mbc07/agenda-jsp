/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Contato;

/**
 *
 * @author 201319050441
 */
public class Main extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String jsp = "/index.jsp";

        if (request.getRequestURI().endsWith("/novo")) {
            jsp = "/novo.jsp";

        } else if (request.getRequestURI().endsWith("/lista")) {
            HttpSession user = request.getSession();

            if (user.getAttribute("contatos") == null) {
                user.setAttribute("contatos", new ArrayList());
            }

            ArrayList contatos = (ArrayList) user.getAttribute("contatos");
            request.setAttribute("listaContatos", contatos);

            jsp = "/lista.jsp";

        } else if (request.getRequestURI().endsWith("/logout")) {
            request.getSession().invalidate();
            request.setAttribute("msgData", "<p>Sessão encerrada.</p>");
            jsp = "/mensagem.jsp";

        } else if (request.getRequestURI().endsWith("/apaga")) {
            HttpSession user = request.getSession();
            String email = request.getParameter("email");
            ArrayList agenda = (ArrayList) user.getAttribute("contatos");

            if (email != null) {
                for (int i = 0; i < agenda.size(); i++) {
                    Contato tmp = (Contato) agenda.get(i);

                    if (tmp.getEmail().equals(email)) {
                        agenda.remove(i);
                        break;
                    }
                }

                user.setAttribute("contatos", agenda);
                jsp = "/lista.jsp";

            } else {
                request.setAttribute("msgData", "<p>Dados não recebidos, por favor tente novamente.</p>");
                request.setAttribute("msgRedirPath", "lista");
                jsp = "/mensagem.jsp";

            }

        } else if (request.getRequestURI().endsWith("/cadastra")) {
            HttpSession user = request.getSession();

            if (user.getAttribute("contatos") == null) {
                user.setAttribute("contatos", new ArrayList());
            }

            ArrayList contatos = (ArrayList) user.getAttribute("contatos");
            String nome = request.getParameter("nome");
            String sobrenome = request.getParameter("sobrenome");
            String email = request.getParameter("email");
            String telefone = request.getParameter("telefone");
            Boolean existe = false;

            if (nome == null) {
                request.setAttribute("msgData", "<p>O campo <strong>Nome</strong> deve ser preenchido!</p>");
                request.setAttribute("msgRedirPath", "novo");

            } else if (email == null) {
                request.setAttribute("msgData", "<p>O campo <strong>E-mail</strong> deve ser preenchido!</p>");
                request.setAttribute("msgRedirPath", "novo");

            } else {
                Contato novo = new Contato(nome, sobrenome, email, telefone);

                for (int i = 0; i < contatos.size(); i++) {
                    Contato tmp = (Contato) contatos.get(i);

                    if (tmp.getEmail().equals(email)) {
                        existe = true;
                        break;
                    }
                }

                if (existe) {
                    request.setAttribute("msgData", "<p>O e-mail especificado já está cadastrado em outro contato!</p>");
                    request.setAttribute("msgRedirPath", "novo");

                } else if (contatos.add(novo)) {
                    request.setAttribute("msgData", "<p>O contato <strong>" + nome + " " + sobrenome
                            + "</strong> foi cadastrado com sucesso!</p>");
                    request.setAttribute("msgRedirPath", "lista");
                    user.setAttribute("contatos", contatos);

                } else {
                    request.setAttribute("msgData", "<p>O contato n&atilde;o foi cadastrado. Tente novamente mais tarde!</p>");
                    request.setAttribute("msgRedirPath", "novo");

                }

            }

            jsp = "/mensagem.jsp";

        }

        request.getRequestDispatcher(jsp).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
