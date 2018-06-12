package br.com.iagocolodetti.ac.modelo;

import java.math.BigInteger;

public class Metodos {
    
    private boolean intTryParse(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private BigInteger fatorial(int n) {
        if (n < 0) return BigInteger.ZERO;
        else if (n == 0) return BigInteger.ONE;
        else if (n == 1) return BigInteger.valueOf(n);
        else return BigInteger.valueOf(n).multiply(fatorial(n - 1));
    }

    private BigInteger permutacaoSimples(int n) {
        return fatorial(n);
    }

    private BigInteger permutacaoRepeticao(int n, int[] p) {
        int s = 0;
        for(int i = 0; i < p.length; i++) s += p[i];
        if(n < s) return BigInteger.ZERO;
        BigInteger resultado, pp = BigInteger.ONE;
        for (int i = 0; i < p.length; i++) pp = pp.multiply(fatorial(p[i]));
        resultado = fatorial(n).divide(pp);
        if (resultado.compareTo(BigInteger.ZERO) == -1) resultado = BigInteger.ZERO;
        return resultado;
    }

    private BigInteger arranjoSimples(int n, int p) {
        if(n < p) return BigInteger.ZERO;
        BigInteger resultado = fatorial(n).divide(fatorial(n - p));
        if (resultado.compareTo(BigInteger.ZERO) == -1) resultado = BigInteger.ZERO;
        return resultado;
    }

    private BigInteger arranjoRepeticao(int n, int p) {
        if (p < 0) return BigInteger.ZERO;
        else if (p == 0) return BigInteger.ONE;
        else if (p == 1) return BigInteger.valueOf(n);
        else return (BigInteger.valueOf(n).multiply(arranjoRepeticao(n, p - 1)));
    }

    private BigInteger combinacaoSimples(int n, int p) {
        if(n < p) return BigInteger.ZERO;
        BigInteger resultado = (fatorial(n).divide(fatorial(n - p).multiply(fatorial(p))));
        if (resultado.compareTo(BigInteger.ZERO) == -1) resultado = BigInteger.ZERO;
        return resultado;
    }

    private BigInteger combinacaoRepeticao(int n, int p) {
        BigInteger resultado = (fatorial(n + p - 1).divide(fatorial(n - 1).multiply(fatorial(p))));
        if (resultado.compareTo(BigInteger.ZERO) == -1) resultado = BigInteger.ZERO;
        return resultado;
    }
    
    public String analiseCombinatoria(int tipo, String n, String p)
            throws NumberFormatException, Exception {
        String resultado;
        int _n, _p = 0;
        final int MIN_NUMBER = 1, MAX_NUMBER = 100;

        //region Tratamento de Erro
        switch (tipo) {
            case 0:
                if (n.isEmpty())
                    throw new Exception("O campo 'n' está vazio.");
                if (!intTryParse(n))
                    throw new NumberFormatException("O valor do campo 'n' não é um inteiro.");
                else
                    _n = Integer.parseInt(n);
                if (_n < MIN_NUMBER || _n > MAX_NUMBER)
                    throw new NumberFormatException("O valor do campo 'n' deve ser um número inteiro positivo de " + MIN_NUMBER + " a " + MAX_NUMBER + ".");
                break;
        //endregion
            case 1:
                if (n.isEmpty())
                    throw new Exception("O campo 'n' está vazio.");
                if (n.isEmpty())
                    throw new Exception("O campo 'p' está vazio.");
                if (!intTryParse(n))
                    throw new NumberFormatException("O valor do campo 'n' não é um inteiro.");
                else
                    _n = Integer.parseInt(n);
                if (_n < MIN_NUMBER || _n > MAX_NUMBER)
                    throw new NumberFormatException("O valor do campo 'n' deve ser um número inteiro positivo de " + MIN_NUMBER + " a " + MAX_NUMBER + ".");
                break;
            default:
                if (n.isEmpty())
                    throw new Exception("O campo 'n' está vazio.");
                if (p.isEmpty())
                    throw new Exception("O campo 'p' está vazio.");
                if (!intTryParse(n))
                    throw new NumberFormatException("O valor do campo 'n' não é um inteiro.");
                else
                    _n = Integer.parseInt(n);
                if (_n < MIN_NUMBER || _n > MAX_NUMBER)
                    throw new NumberFormatException("O valor do campo 'n' deve ser um número inteiro positivo de " + MIN_NUMBER + " a " + MAX_NUMBER + ".");
                if (!intTryParse(p))
                    throw new NumberFormatException("O valor do campo 'p' não é um inteiro.");
                else
                    _p = Integer.parseInt(p);
                if (_p < MIN_NUMBER || _p > MAX_NUMBER)
                    throw new NumberFormatException("O valor do campo 'p' deve ser um número inteiro positivo de " + MIN_NUMBER + " a " + MAX_NUMBER + ".");
                if((tipo != 3 && tipo != 5) && _n < _p)
                    throw new NumberFormatException("O valor do campo 'p' deve ser menor ou igual ao valor do campo 'n'.");
                break;
        }

        switch (tipo) {
            case 0:
                resultado = "P(n) => P(" + n + ")<br>" + permutacaoSimples(_n).toString();
                break;
            case 1:
                String exibir = "P(n,(p,p,...)) => P(" + n + ",(";
                String[] sPP = p.replace(" ", "").split(",");
                int[] pp = new int[sPP.length];
                for (int i = 0; i < sPP.length; i++) {
                    //region Tratamento de Erro (p por p)
                    if (!intTryParse(sPP[i]))
                        throw new NumberFormatException("Um valor do campo 'p,p,...' não é um inteiro.");
                    else
                        _p = Integer.parseInt(sPP[i]);
                    if (_p < MIN_NUMBER || _p > MAX_NUMBER)
                        throw new NumberFormatException("Os valores do campo 'p,p,...' devem ser números inteiros positivos de " + MIN_NUMBER + " a " + MAX_NUMBER + ".");
                    //endregion
                    if (i == 0) exibir += sPP[i];
                    else exibir += "," + sPP[i];
                    pp[i] = _p;
                }
                //region Tratamento de Erro
                int s = 0;
                for(int i = 0; i < pp.length; i++) s += pp[i];
                if(_n < s)
                    throw new NumberFormatException("O valor total do campo 'p' deve ser menor ou igual ao valor do campo 'n'.");
                //endregion
                resultado = exibir + "))<br>" + permutacaoRepeticao(_n, pp).toString();
                break;
            case 2:
                resultado = "A(n,p) => A(" + n + "," + p + ")<br>" + arranjoSimples(_n, _p).toString();
                break;
            case 3:
                resultado = "AR(n,p) => AR(" + n + "," + p + ")<br>" + arranjoRepeticao(_n, _p).toString();
                break;
            case 4:
                resultado = "C(n,p) => C(" + n + "," + p + ")<br>" + combinacaoSimples(_n, _p).toString();
                break;
            case 5:
                resultado = "CR(n,p) => CR(" + n + "," + p + ")<br>" + combinacaoRepeticao(_n, _p).toString();
                break;
            default:
                resultado = "Tipo incorreto.";
                break;
        }
        return resultado;
    }
}
