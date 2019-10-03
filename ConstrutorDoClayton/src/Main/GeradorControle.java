/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.ArrayList;
import java.util.List;
import tools.ManipulaArquivo;

/**
 *
 * @author a1903691
 */
public class GeradorControle {
  
    public static String primeiraLetramaiscula(String s){
       return String.valueOf(s.charAt(0)).toUpperCase() + s.substring(1,s.length());
    }
    public GeradorControle(){
        
        String nomeDaClasse = "Atleta";
        String nomeDaClasseMinuscula = "atleta";
        List<String> atributo = new ArrayList<>();
        List<String> codigo = new ArrayList<>();
        atributo.add("int;id");
        atributo.add("String;nome");
        atributo.add("double;altura");
        atributo.add("String;esporte");
        atributo.add("double;peso");
        
        codigo.add("package Main;\n\n\n"+"import java.util.ArrayList;\n" +
"import java.util.List;\n\n\n" +
""
                
                + "public class Controle {");
        codigo.add("private List<"+nomeDaClasse+"> lista = new ArrayList<>();");
        codigo.add("public Controle() {\n\n}");
        codigo.add("public void limparLista(){\n" +
"        lista.clear();//zera a lista\n" +
"    }");
        codigo.add("public void adicionar("+nomeDaClasse+" "+nomeDaClasseMinuscula+") {\nlista.add("+nomeDaClasseMinuscula+");");
        codigo.add("}");
        codigo.add("public List<"+nomeDaClasse+"> listar() {\n" +
"        return lista;\n" +
"    }");
         
        String aux[] = atributo.get(0).split(";");
        if (aux[0].equals("int")||aux[0].equals("double")||aux[0].equals("float")) {
            codigo.add("public " +nomeDaClasse+" buscar("+aux[0]+" " +aux[1]+") {\n" +
"           for (int i = 0; i < lista.size(); i++) {\n" +
"            if (lista.get(i).get"+primeiraLetramaiscula(aux[1])+"() =="+aux[1]+") {\n" +
"                return lista.get(i);\n" +
"            }\n" +
"        }\n" +
"        return null;");
        }else{
        codigo.add("public " +nomeDaClasse+" buscar("+aux[0]+" " +aux[1]+") {\n" +
"        for (int i = 0; i < lista.size(); i++) {\n" +
"            if (lista.get(i).get"+primeiraLetramaiscula(aux[1])+"().equals("+aux[1]+")) {\n" +
"                return lista.get(i);\n" +
"            }\n" +
"        }\n" +
"        return null;");
        }
        codigo.add("}");
        
        codigo.add("public void alterar("+nomeDaClasse+" "+nomeDaClasseMinuscula+", " +nomeDaClasse+" "+nomeDaClasseMinuscula+"Antigo) {\n" +
"        lista.set(lista.indexOf("+nomeDaClasseMinuscula+"Antigo), "+nomeDaClasseMinuscula+");\n" +
"\n" +
"    }\n" +
"");
        
       codigo.add("public void excluir("+nomeDaClasse+" "+nomeDaClasseMinuscula+") {\n" +
"        lista.remove("+nomeDaClasseMinuscula+");\n" +
"    }");
        codigo.add("}");
         
        
        for (int i = 0; i < codigo.size(); i++) {
            System.out.println(codigo.get(i));
        ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
        manipulaArquivo.salvarArquivo("/home/todos/alunos/cm/a1903691/NetBeansProjects/Cobaia1/src/Main/Controle.java", codigo);
    }
    
}
}