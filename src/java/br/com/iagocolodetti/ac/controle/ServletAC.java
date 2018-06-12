package br.com.iagocolodetti.ac.controle;

import br.com.iagocolodetti.ac.modelo.Metodos;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletAC extends HttpServlet {
    
    private String getResultado(String tipo, String n, String p) {
        String resultado;
        if (!tipo.isEmpty()) {
            int TipoSelecionado = 0;
            switch (tipo) {
                case "ps":
                    TipoSelecionado = 0;
                    break;
                case "pr":
                    TipoSelecionado = 1;
                    break;
                case "as":
                    TipoSelecionado = 2;
                    break;
                case "ar":
                    TipoSelecionado = 3;
                    break;
                case "cs":
                    TipoSelecionado = 4;
                    break;
                case "cr":
                    TipoSelecionado = 5;
                    break;
                default:
                    break;
            }
            try {
                resultado = new Metodos().analiseCombinatoria(TipoSelecionado, n, p);
            }
            catch (NumberFormatException e) {
                resultado = e.getMessage();
            }
            catch (Exception e) {
                resultado = e.getMessage();
            }
        }
        else resultado = "Selecione o tipo.";
        return resultado;
    }
    
    private void manterDados(HttpServletRequest request)
            throws ServletException, IOException {
        String tipo = request.getParameter("tipo");
        switch (tipo) {
            case "ps":
                request.setAttribute("tipoSelecionado", "Permutação Simples");
                break;
            case "pr":
                request.setAttribute("tipoSelecionado", "Permutação com Repetição");
                break;
            case "as":
                request.setAttribute("tipoSelecionado", "Arranjo Simples");
                break;
            case "ar":
                request.setAttribute("tipoSelecionado", "Arranjo com Repetição");
                break;
            case "cs":
                request.setAttribute("tipoSelecionado", "Combinação Simples");
                break;
            case "cr":
                request.setAttribute("tipoSelecionado", "Combinação com Repetição");
                break;
            default:
                break;
        }
        request.setAttribute("tipoSigla", tipo);
        request.setAttribute("valorP", (request.getParameter("p") != null ? request.getParameter("p") : ""));
        request.setAttribute("valorN", (request.getParameter("n") != null ? request.getParameter("n") : ""));
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        manterDados(request);
        String disableP, placeholderP;
        if (request.getParameter("tipo") != null && request.getParameter("tipo").equals("ps")) {
            disableP = "disabled";
            placeholderP = "Desativado";
        }
        else if (request.getParameter("tipo") != null && request.getParameter("tipo").equals("pr")) {
            disableP = "";
            placeholderP = "Digite o valor de P,P,...";
        }
        else {
            disableP = "";
            placeholderP = "Digite o valor de P";
        }
        request.setAttribute("disableP", disableP);
        request.setAttribute("placeholderP", placeholderP);
        request.getRequestDispatcher("ac.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("resultado", getResultado(request.getParameter("tipo"), request.getParameter("n"), request.getParameter("p")));
        manterDados(request);
        request.getRequestDispatcher("ac.jsp").forward(request, response);
    }
}
