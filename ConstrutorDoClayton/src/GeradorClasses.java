import java.util.ArrayList;
import java.util.List;
import tools.ManipulaArquivo;

/**
 *
 * @author a1903691
 */
public class GeradorClasses {
    public static String primeiraLetramaiscula(String s){
       return String.valueOf(s.charAt(0)).toUpperCase() + s.substring(1,s.length());
    }
    
    public GeradorClasses(){
        String nomeDaClasse = "Atleta";
        List<String> atributo = new ArrayList<>();
        List<String> codigo = new ArrayList<>();
        atributo.add("int;id");
        atributo.add("String;nome");
        atributo.add("double;altura");
        atributo.add("String;esporte");
        atributo.add("double;peso");

        codigo.add("package Main;\n"
                + "public class " + nomeDaClasse + " {");
        for (int i = 0; i < atributo.size(); i++) {
            String aux[] = atributo.get(i).split(";");
            codigo.add("private " + aux[0] + " " + aux[1] + ";");
        }

        codigo.add("\n"
                + " public " + nomeDaClasse + "() {\n"
                + "    }");
        codigo.add("\n"
                + " public " + nomeDaClasse + "(");
        String a = "";
          for (int i = 0; i < atributo.size(); i++) {
            String aux[] = atributo.get(i).split(";");
            String c = aux[0] + " " + aux[1]+",";
            a=a+c;
          }
          
         a=a.substring(0,a.length()-1);
         codigo.add(a+") {");
         for (int i = 0; i < atributo.size(); i++) {
            String aux[] = atributo.get(i).split(";");
            codigo.add("this."+aux[1]+" = "+aux[1]+";");
         }
         codigo.add("}");
         for (int i = 0; i < atributo.size(); i++) {
            String aux[] = atributo.get(i).split(";");
            codigo.add("public "+aux[0] +" get"+primeiraLetramaiscula(aux[1])+"(){\nreturn "+aux[1]+";\n }");
            codigo.add("public void "+" set"+primeiraLetramaiscula(aux[1])+"("+aux[0]+"  "+aux[1]+") {\n    this."+aux[1]+" = "+aux[1]+";\n }");
         }
         codigo.add("@Override");
         codigo.add("public String toString() {");
 
         String s1 = " ";
for (int i = 0; i < atributo.size(); i++) {
            String aux[] = atributo.get(i).split(";");
            String s = "\""+aux[1]+"=\""+" + "+aux[1]+" + ";
            s1=s1+s;
                }
            codigo.add("return "+"\""+nomeDaClasse+"{\""+"+"+s1+"\"}\";");
            codigo.add("}");
            codigo.add("}");
            
        for (int i = 0; i < codigo.size(); i++) {
            System.out.println(codigo.get(i));

        }
        ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
        manipulaArquivo.salvarArquivo("/home/todos/alunos/cm/a1903691/NetBeansProjects/Cobaia1/src/Main/Atleta.java", codigo);
        
    }

}
