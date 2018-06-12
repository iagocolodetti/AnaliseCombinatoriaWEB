package br.com.iagocolodetti.ac.controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletACInfo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String tipo = request.getParameter("tipo");
        switch (tipo) {
            case "ps":
                request.setAttribute("tipoSelecionado", "Permutação Simples");
                request.setAttribute("tipoSelecionadoImg", "imgs/permutacaosimples.png");
                request.setAttribute("tipoSelecionadoInfo",
                                    "Permutação simples é definida como sendo o número de maneiras de arrumar 'n'"
                                    + " elementos em 'n' posições em que cada maneira se diferencia pela ordem em que os elementos aparecem.");
                break;
            case "pr":
                request.setAttribute("tipoSelecionado", "Permutação com Repetição");
                request.setAttribute("tipoSelecionadoImg", "imgs/permutacaocomrepeticao.png");
                request.setAttribute("tipoSelecionadoInfo",
                                    "Permutação com repetição é definida como sendo o número de maneiras de arrumar 'n'"
                                    + " elementos em 'n' posições com repetição de elementos em que cada maneira se diferencia pela ordem em que os elementos aparecem."
                                    + "<br>"
                                    + "Onde 'n' é o número total de elementos e 'p', 'p',... são os números de repetições de elementos.");
                break;
            case "as":
                request.setAttribute("tipoSelecionado", "Arranjo Simples");
                request.setAttribute("tipoSelecionadoImg", "imgs/arranjosimples.png");
                request.setAttribute("tipoSelecionadoInfo",
                                    "Arranjo simples é usado quando a ordem dos elementos importa e cada elemento pode ser contado apenas uma vez."
                                    + "<br>"
                                    + "Onde 'n' é o número total de elementos e 'p' é a quantidade total de elementos escolhidos.");
                break;
            case "ar":
                request.setAttribute("tipoSelecionado", "Arranjo com Repetição");
                request.setAttribute("tipoSelecionadoImg", "imgs/arranjocomrepeticao.png");
                request.setAttribute("tipoSelecionadoInfo",
                                    "Arranjo com repetição é usado quando a ordem dos elementos importa e cada elemento pode ser contado mais de uma vez."
                                    + "<br>"
                                    + "Onde 'n' é o número total de elementos e 'p' é a quantidade total de elementos escolhidos.");
                break;
            case "cs":
                request.setAttribute("tipoSelecionado", "Combinação Simples");
                request.setAttribute("tipoSelecionadoImg", "imgs/combinacaosimples.png");
                request.setAttribute("tipoSelecionadoInfo",
                                    "Combinação simples é usado quando a ordem dos elementos não importa e cada elemento pode ser contado apenas uma vez."
                                    + "<br>"
                                    + "Onde 'n' é o número total de elementos e 'p' é a quantidade total de elementos escolhidos.");
                break;
            case "cr":
                request.setAttribute("tipoSelecionado", "Combinação com Repetição");
                request.setAttribute("tipoSelecionadoImg", "imgs/combinacaocomrepeticao.png");
                request.setAttribute("tipoSelecionadoInfo",
                                    "Combinação com repetição é usado quando a ordem dos elementos não importa e cada elemento pode ser contado mais de uma vez."
                                    + "<br>"
                                    + "Onde 'n' é o número total de elementos e 'p' é a quantidade total de elementos escolhidos.");
                break;
            default:
                request.setAttribute("tipoSelecionado", "");
                request.setAttribute("tipoSelecionadoImg", "");
                request.setAttribute("tipoSelecionadoInfo", "");
                break;
        }
        request.getRequestDispatcher("info.jsp").forward(request, response);
    }
}
