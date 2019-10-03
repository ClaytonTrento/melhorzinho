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
public class GeradordeGUI {
    
public static String primeiraLetramaiscula(String s){
       return String.valueOf(s.charAt(0)).toUpperCase() + s.substring(1,s.length());
    }
public GeradordeGUI(){
     String nomeDaClasse = "Atleta";
        String nomeDaClasseMinuscula = "atleta";
        List<String> atributo = new ArrayList<>();
        List<String> codigo = new ArrayList<>();
        atributo.add("int;id");
        atributo.add("String;nome");
        atributo.add("double;altura");
        atributo.add("String;esporte");
        atributo.add("double;peso");
        codigo.add("package Main;\n" +
"\n" +
"import java.awt.BorderLayout;\n" +
"import java.awt.CardLayout;\n" +
"import java.awt.Container;\n" +
"import java.awt.GridLayout;\n" +
"import java.awt.event.ActionEvent;\n" +
"import java.awt.event.ActionListener;\n" +
"import java.awt.event.WindowAdapter;\n" +
"import java.awt.event.WindowEvent;\n" +
"import java.util.ArrayList;\n" +
"import java.util.List;\n" +
"import javax.swing.JButton;\n" +
"import javax.swing.JCheckBox;\n" +
"import javax.swing.JFrame;\n" +
"import javax.swing.JLabel;\n" +
"import javax.swing.JOptionPane;\n" +
"import javax.swing.JPanel;\n" +
"import javax.swing.JScrollPane;\n" +
"import javax.swing.JTable;\n" +
"import javax.swing.JTextArea;\n" +
"import javax.swing.JTextField;\n" +
"import javax.swing.JToolBar;\n" +
"import javax.swing.table.DefaultTableModel;\n" +
"import tools.ManipulaArquivo;" +

"\n" +
"/**\n" +
" *\n" +
" * @author radames\n" +
" */\n" +
"public class GUI extends JFrame {\n" +
"\n" +
"    private Container cp;");
         for (int i = 0; i < atributo.size(); i++) {
            String aux[] = atributo.get(i).split(";");
        if (aux[0].equals("boolean")) {
                codigo.add("private JCheckBox cb" + primeiraLetramaiscula(aux[1]) + " = new  JCheckBox(\""
                        + primeiraLetramaiscula(aux[1]) + "\", false);\n");
            } else if (aux[0].equals("DateTextField") || aux[0].equals("Date")) {
                codigo.add("private DateTextField tf" + aux[1] + " = new DateTextField();");
                codigo.add("private JLabel lb" + aux[1] + " = new JLabel(\"" + aux[1] + "\");");
                //codigo.add("SimpleDateFormat sdf = new SimpleDateFormat(\"dd/MM/yyyy\");\n");
            } else if (!aux[0].equals("boolean") || !aux[0].equals("DateTextField") || !aux[0].equals("Date")) {
                codigo.add("private JLabel lb" + primeiraLetramaiscula(aux[1]) + " = new JLabel(\"" + aux[1] + "\");");
                codigo.add("private JTextField tf" + primeiraLetramaiscula(aux[1]) + " = new JTextField(20);");
            }
        }
         
codigo.add("\n private JButton btAdicionar = new JButton(\"Adicionar\");\n" +
"    private JButton btListar = new JButton(\"Listar\");\n" +
"    private JButton btBuscar = new JButton(\"Buscar\");\n" +
"    private JButton btAlterar = new JButton(\"Alterar\");\n" +
"    private JButton btExcluir = new JButton(\"Excluir\");\n" +
"    private JButton btSalvar = new JButton(\"Salvar\");\n" +
"    private JButton btCancelar = new JButton(\"Cancelar\");\n" +
"    private JButton btCarregarDados = new JButton(\"Carregar\");\n" +
"    private JButton btGravar = new JButton(\"Gravar\");\n" +
"    private JToolBar toolBar = new JToolBar();\n" +
"    private JPanel painelNorte = new JPanel();\n" +
"    private JPanel painelCentro = new JPanel();\n" +
"    private JPanel painelSul = new JPanel();\n" +
"    private JTextArea texto = new JTextArea();\n" +
"    private JScrollPane scrollTexto = new JScrollPane();\n" +
"    private JScrollPane scrollTabela = new JScrollPane();\n");

   codigo.add("private String acao = \"\";\n" +
"    private String chavePrimaria = \"\";\n" +
"\n" +
"    private Controle controle = new Controle();\n" +
"    private "+nomeDaClasse+" "+nomeDaClasseMinuscula+" = new "+nomeDaClasse+"();");
        
    int c = 0;
    String a = " ";
        for (int i = 0; i < atributo.size(); i++) {
            String aux[] = atributo.get(i).split(";");
            String s ="\""+primeiraLetramaiscula(aux[1])+"\",";
         
            a=a+s;
            c=c+1;
        }
        a=a.substring(0,a.length()-1);
        codigo.add("String[] colunas = new String[]{"+a+"};");
    
    
        
        codigo.add("String[][] dados = new String[0]["+c+"];");
        codigo.add("DefaultTableModel model = new DefaultTableModel(dados, colunas);\n" +
"    JTable tabela = new JTable(model);\n" +
"\n" +
"    private JPanel painel1 = new JPanel(new GridLayout(1, 1));\n" +
"    private JPanel painel2 = new JPanel(new GridLayout(1, 1));\n" +
"    private CardLayout cardLayout;\n" +
"\n" +
"    public GUI() {\n" +
"\n" +
"        String caminhoENomeDoArquivo = \"DadosTrabalhador.csv\";\n" +
"\n" +
"        setDefaultCloseOperation(DISPOSE_ON_CLOSE);\n" +
"\n" +
"        setSize(600, 400);\n" +
"        setTitle(\"GUI DO CLAYTON\");\n" +
"        setLocationRelativeTo(null);//centro do monitor\n" +
"\n" +
"        cp = getContentPane();\n" +
"\n" +
"        cp.setLayout(new BorderLayout());\n" +
"        cp.add(painelNorte, BorderLayout.NORTH);\n" +
"        cp.add(painelCentro, BorderLayout.CENTER);\n" +
"        cp.add(painelSul, BorderLayout.SOUTH);\n" +
"\n" +
"        cardLayout = new CardLayout();\n" +
"        painelSul.setLayout(cardLayout);\n" +
"\n" +
"        painel1.add(scrollTexto);\n" +
"        painel2.add(scrollTabela);\n" +
"\n" +
"        texto.setText(\"\\n\\n\\n\\n\\n\\n\");//5 linhas de tamanho\n" +
"        scrollTexto.setViewportView(texto);\n" +
"\n" +
"        painelSul.add(painel1, \"Avisos\");\n" +
"        painelSul.add(painel2, \"Listagem\");\n" +
"        tabela.setEnabled(false);");
        codigo.add("painelNorte.setLayout(new GridLayout(1, 1));\n" +
"        painelNorte.add(toolBar);\n" +
"\n" +
"        painelCentro.setLayout(new GridLayout("+c+", 2));");
        
        for (int i = 1; i < atributo.size(); i++) {
            String aux[] = atributo.get(i).split(";");
            codigo.add("painelCentro.add(lb"+primeiraLetramaiscula(aux[1])+");");
        }
        String aux[] = atributo.get(0).split(";");
        codigo.add(" toolBar.add(lb"+primeiraLetramaiscula(aux[1])+");");
        codigo.add(" toolBar.add(tf"+primeiraLetramaiscula(aux[1])+");");
        codigo.add(" toolBar.add(btAdicionar);\n" +
"        toolBar.add(btBuscar);\n" +
"        toolBar.add(btListar);\n" +
"        toolBar.add(btAlterar);\n" +
"        toolBar.add(btExcluir);\n" +
"        toolBar.add(btSalvar);\n" +
"        toolBar.add(btCancelar);");
        codigo.add("btAdicionar.setVisible(false);\n" +
"        btAlterar.setVisible(false);\n" +
"        btExcluir.setVisible(false);\n" +
"        btSalvar.setVisible(false);\n" +
"        btCancelar.setVisible(false);\n" +
"");
        for (int i = 1; i < atributo.size(); i++) {
            aux = atributo.get(i).split(";");
        if(aux[0].equals("Bollean")){    
            codigo.add("cb" + primeiraLetramaiscula(aux[1]) + ".setSelected(false);\n");
            } else if (aux[0].equals("DateTextField") || aux[0].equals("Date")) {
                codigo.add("tf" + primeiraLetramaiscula(aux[1]) + ".setText(\"\");\n");
                //codigo.add("SimpleDateFormat sdf = new SimpleDateFormat(\"dd/MM/yyyy\");\n");
            } else if (!aux[0].equals("boolean") || !aux[0].equals("DateTextField") || !aux[0].equals("Date")) {
                codigo.add("tf" + primeiraLetramaiscula(aux[1]) + ".setText(\"\");\n");
            }     
        }
        codigo.add("btCarregarDados.addActionListener(new ActionListener() {\n" +
"            @Override\n" +
"            public void actionPerformed(ActionEvent e) {\n" +
"                ManipulaArquivo manipulaArquivo = new ManipulaArquivo(); //classe para facilitar o trabalho com arquivos\n" +
"                if (manipulaArquivo.existeOArquivo(caminhoENomeDoArquivo)) { //só dá para carregar dados se o arquivo existir\n" +
"                    String aux[];\n" +
"                    "+nomeDaClasse+" t;\n" +
"                    List<String> listaStringCsv = manipulaArquivo.abrirArquivo(caminhoENomeDoArquivo);//traz os dados em formato string\n" +
"                    for (String linha : listaStringCsv) {//para cada linha da lista\n" +
"                        aux = linha.split(\";\");//divida os campos nos ;\n");
                String se = "";
                     for (int i = 0; i < atributo.size(); i++) {
                            aux = atributo.get(i).split(";");
                            if (aux[0]== "double") {
                                String s = "Double.valueOf(aux["+i+"]),";     
                                se=se+s;
                         }else if (aux[0]=="int") {
                             String s = "Integer.valueOf(aux["+i+"]),";
                             se=se+s;
                         }else if (aux[0]=="float") {
                             String s = "Float.valueOf(aux["+i+"]),";
                             se=se+s;
                         }else if (aux[0]=="Date") {
                             String s = "Format(aux["+i+"]),";
                             se=se+s;
                         }else if (aux[0]=="boolean") {
                             String s = "Boolean.valueOf.(aux["+i+"]),";
                             se=se+s;
                                   
                     }else if(aux[0]=="String"){
                             String s = "aux["+i+"],";
                             se=se+s;
                         }
                     }
                            
                            se=se.substring(0,se.length()-1);
                     codigo.add(
"                        t = new "+nomeDaClasse+"("+se+");"+
         "//crie um objeto Trabalhador e preencha com dados.\n" +
"                        controle.adicionar(t); //adicione na lista\n" +
"                    }\n" +
"                    cardLayout.show(painelSul, \"Listagem\");\n" +
"                }\n" +
"            }\n" +
"        });");
        codigo.add(" btGravar.addActionListener(new ActionListener() {\n" +
"            @Override\n" +
"            public void actionPerformed(ActionEvent e) {\n" +
"                //1) converter de uma list<trabalhador> para list<string>\n" +
"                List<"+nomeDaClasse+"> lista"+nomeDaClasse+" = controle.listar();//obtem a lista toda\n" +
"                List<String> lista"+nomeDaClasse+"EmFormatoStringCSV = new ArrayList<>();\n" +
"                for ("+nomeDaClasse+" t : lista"+nomeDaClasse+") { //percorre toda a lista de trabalhadores\n" +
"                    lista"+nomeDaClasse+"EmFormatoStringCSV.add(t.toString());//para cada trabalhador t, transforme em string.\n" +
"                }\n" +
"                new ManipulaArquivo().salvarArquivo(caminhoENomeDoArquivo, lista"+nomeDaClasse+"EmFormatoStringCSV);\n" +
"                System.out.println(\"gravou\");\n" +
"            }\n" +
"        });");
        codigo.add("btBuscar.addActionListener(new ActionListener() {\n" +
"            @Override\n" +
"            public void actionPerformed(ActionEvent e) {\n" +
"                btAdicionar.setVisible(false);\n" +
"\n" +
"                cardLayout.show(painelSul, \"Avisos\");\n" +
"                scrollTexto.setViewportView(texto);\n");
        
        aux = atributo.get(0).split(";");
        codigo.add("if (tf"+primeiraLetramaiscula(aux[1])+".getText().trim().isEmpty()) {\n" +
"                    JOptionPane.showMessageDialog(cp, \"CPF nâo pode ser vazio\");\n" +
"                    tf"+primeiraLetramaiscula(aux[1])+".requestFocus();\n" +
"                    tf"+primeiraLetramaiscula(aux[1])+".selectAll();\n" +
"                } else {\n" +
"                    chavePrimaria = tf"+primeiraLetramaiscula(aux[1])+".getText();//para uso no adicionar\n" +
"                    "+nomeDaClasseMinuscula+" = controle.buscar(Integer.valueOf(tf"+primeiraLetramaiscula(aux[1])+".getText()));\n" +
"                    if ("+nomeDaClasseMinuscula+" == null) {//nao encontrou\n" +
"                        btAdicionar.setVisible(true);\n" +
"                        btAlterar.setVisible(false);\n" +
"                        btExcluir.setVisible(false);\n" );
        for (int i = 1; i < atributo.size(); i++) {
            aux = atributo.get(i).split(";");
            if (aux[0].equals("bollean")) {
                codigo.add("cb"+primeiraLetramaiscula(aux[1])+".setSelected(false);\n");
            }else{
            codigo.add("tf"+primeiraLetramaiscula(aux[1])+".setText(\"\");\n");
        }
        }
codigo.add("texto.setText(\"Não encontrou na lista - pode Adicionar\\n\\n\\n\");//limpa o campo texto\n" +
"\n" +
"                    } else {//encontrou\n");

        for (int i = 1; i < atributo.size(); i++) {
            aux = atributo.get(i).split(";");
            if (aux[0].equals("bollean")) {
                codigo.add("cb"+primeiraLetramaiscula(aux[1])+".setSelected("+nomeDaClasseMinuscula+".is"+primeiraLetramaiscula(aux[1])+"()));");
            }else if(aux[0].equals("int")||aux[0].equals("float")||aux[0].equals("double")){
            codigo.add("tf"+primeiraLetramaiscula(aux[1])+".setText(String.valueOf("+nomeDaClasseMinuscula+".get"+primeiraLetramaiscula(aux[1])+"()));");     
            }else{
                codigo.add("tf"+primeiraLetramaiscula(aux[1])+".setText("+nomeDaClasseMinuscula+".get"+primeiraLetramaiscula(aux[1])+"());");
            }
        }
codigo.add("btAlterar.setVisible(true);\n" +
"                        btExcluir.setVisible(true);\n" +
"                        texto.setText(\"Encontrou na lista - pode Alterar ou Excluir\\n\\n\\n\");//limpa o campo texto\n");
        for (int i = 1; i < atributo.size(); i++) {
            aux = atributo.get(i).split(";");
            if (aux[0].equals("bollean")) {
            codigo.add("cb"+primeiraLetramaiscula(aux[1])+".setEnabled(false);");
        }else{
                codigo.add("tf"+primeiraLetramaiscula(aux[1])+".setEditable(false);//atributos começam bloqueados");
            }
        }
codigo.add(
"                    }\n" +
"                }\n" +
"            }\n" +
"        });");
codigo.add("  btAdicionar.addActionListener(new ActionListener() {\n" +
"            @Override\n" +
"            public void actionPerformed(ActionEvent e) {\n" +
"                acao = \"adicionar\";\n");

            aux = atributo.get(0).split(";");
            codigo.add(
"                tf"+primeiraLetramaiscula(aux[1])+".setText(chavePrimaria);//para retornar ao valor original (caso o usuário mude e tente enganar o programa)\n" +
"                tf"+primeiraLetramaiscula(aux[1])+".setEditable(false);\n");
            aux = atributo.get(1).split(";");
codigo.add(
"                tf"+primeiraLetramaiscula(aux[1])+".requestFocus();\n" +
"                btSalvar.setVisible(true);\n" +
"                btCancelar.setVisible(true);\n" +
"                btBuscar.setVisible(false);\n" +
"                btListar.setVisible(false);\n" +
"                btAlterar.setVisible(false);\n" +
"                btExcluir.setVisible(false);\n" +
"\n" +
"                btAdicionar.setVisible(false);\n" +
"                texto.setText(\"Preencha os atributos\\n\\n\\n\\n\\n\");//limpa o campo texto\n");
                for (int i = 1; i < atributo.size(); i++) {
                           aux = atributo.get(i).split(";");
                           if (aux[0].equals("boolean")) {
                            codigo.add("cb"+primeiraLetramaiscula(aux[1])+".setEnabled(true);");
                    }else{
                            codigo.add("tf"+primeiraLetramaiscula(aux[1])+".setEditable(true);");
                           }
                }
                           codigo.add(
       
"            }\n" +
"        });");
        codigo.add("btAlterar.addActionListener(new ActionListener() {\n" +
"            @Override\n" +
"            public void actionPerformed(ActionEvent e) {\n" +
"                acao = \"alterar\";");
        aux = atributo.get(0).split(";");
        codigo.add(
"                tf"+primeiraLetramaiscula(aux[1])+".setText(chavePrimaria);//para retornar ao valor original (caso o usuário mude e tente enganar o programa)\n" +
"                tf"+primeiraLetramaiscula(aux[1])+".setEditable(false);\n");
        aux = atributo.get(1).split(";");
        codigo.add(
"                tf"+primeiraLetramaiscula(aux[1])+".requestFocus();\n" +
"                btSalvar.setVisible(true);\n" +
"                btCancelar.setVisible(true);\n" +
"                btBuscar.setVisible(false);\n" +
"                btListar.setVisible(false);\n" +
"                btAlterar.setVisible(false);\n" +
"                btExcluir.setVisible(false);\n" +
"                texto.setText(\"Preencha os atributos\\n\\n\\n\\n\\n\");//limpa o campo texto\n");
                 for (int i = 1; i < atributo.size(); i++) {
                           aux = atributo.get(i).split(";");
                           if (aux[0].equals("bollean")) {
                            codigo.add("cb"+primeiraLetramaiscula(aux[1])+".setEnabled(true);");
                    }else{
                            codigo.add("tf"+primeiraLetramaiscula(aux[1])+".setEditable(true);");
                           }
                }
                 codigo.add(
"            }\n" +
"        });"); 
        codigo.add("btCancelar.addActionListener(new ActionListener() {\n" +
"            @Override\n" +
"            public void actionPerformed(ActionEvent e) {\n" +
"                btSalvar.setVisible(false);\n" +
"                btCancelar.setVisible(false);\n" +
"                btBuscar.setVisible(true);\n" +
"                btListar.setVisible(true);\n");
                aux = atributo.get(0).split(";");
                codigo.add(
"                tf"+primeiraLetramaiscula(aux[1])+".setEditable(true);\n");
                for (int i = 1; i < atributo.size(); i++) {
                           aux = atributo.get(i).split(";");
                           if (aux[0].equals("bollean")) {
                            codigo.add("cb"+primeiraLetramaiscula(aux[1])+".setSelected(false);");
                    }else{
                            codigo.add("tf"+primeiraLetramaiscula(aux[1])+".setText(\"\");");
                           }
                }
                
        aux = atributo.get(0).split(";");
        codigo.add(
        
"                tf"+primeiraLetramaiscula(aux[1])+".requestFocus();\n" +
"                tf"+primeiraLetramaiscula(aux[1])+".selectAll();\n" +
"                texto.setText(\"Cancelou\\n\\n\\n\\n\\n\");//limpa o campo texto");
        for (int i = 1; i < atributo.size(); i++) {
                           aux = atributo.get(i).split(";");
                           if (aux[0].equals("bollean")) {
                            codigo.add("cb"+primeiraLetramaiscula(aux[1])+".setEnabled(false);");
                    }else{
                            codigo.add("tf"+primeiraLetramaiscula(aux[1])+".setEditable(false);");
                           }
                }
codigo.add(               
"            }\n" +
"        });");
                 codigo.add("btSalvar.addActionListener(new ActionListener() {\n" +
"            @Override\n" +
"            public void actionPerformed(ActionEvent e) {\n" +
"                if (acao.equals(\"alterar\")) {\n"
                         +"                    "+nomeDaClasse+" "+nomeDaClasseMinuscula+"Antigo = "+nomeDaClasseMinuscula+";" );
                for (int i = 1; i < atributo.size(); i++) {
                           aux = atributo.get(i).split(";");
                           if (aux[0].equals("bollean")) {
                               codigo.add(nomeDaClasseMinuscula+".set"+primeiraLetramaiscula(aux[1])+"(cb"+primeiraLetramaiscula(aux[1])+".isSelected());");
                    }else if (aux[0].equals("double")) {
                               codigo.add(nomeDaClasseMinuscula+".set"+primeiraLetramaiscula(aux[1])+"(Double.valueOf(tf"+primeiraLetramaiscula(aux[1])+".getText()));");
                }else if (aux[0].equals("int")) {
                               codigo.add(nomeDaClasseMinuscula+".set"+primeiraLetramaiscula(aux[1])+"(Integer.valueOf(tf"+primeiraLetramaiscula(aux[1])+".getText()));");
                }else if (aux[0].equals("Date")) {
                               codigo.add(nomeDaClasseMinuscula+".set"+primeiraLetramaiscula(aux[1])+".Format(tf"+primeiraLetramaiscula(aux[1])+".getText()));");
                    
                }else if (aux[0].equals("float")) {
                               codigo.add(nomeDaClasseMinuscula+".set"+primeiraLetramaiscula(aux[1])+"(Float.valueOf(tf"+primeiraLetramaiscula(aux[1])+".getText()));");
                }else{
                    codigo.add(nomeDaClasseMinuscula+".set"+primeiraLetramaiscula(aux[1])+"(tf"+primeiraLetramaiscula(aux[1])+".getText());");
                }
                }
                 codigo.add(
"                    controle.alterar("+nomeDaClasseMinuscula+", "+nomeDaClasseMinuscula+"Antigo);\n" +
"                    texto.setText(\"Registro alterado\\n\\n\\n\\n\\n\");//limpa o campo texto\n" +
"                } else {//adicionar\n" +
"                    "+nomeDaClasseMinuscula+" = new "+nomeDaClasse+"();");
                 aux = atributo.get(0).split(";");
                 for (int i = 0; i < atributo.size(); i++) {
                           aux = atributo.get(i).split(";");
                           if (aux[0].equals("bollean")) {
                               codigo.add(nomeDaClasseMinuscula+".set"+primeiraLetramaiscula(aux[1])+"(cb"+primeiraLetramaiscula(aux[1])+".isSelected());");
                    }else if (aux[0].equals("double")) {
                               codigo.add(nomeDaClasseMinuscula+".set"+primeiraLetramaiscula(aux[1])+"(Double.valueOf(tf"+primeiraLetramaiscula(aux[1])+".getText()));");
                }else if (aux[0].equals("int")) {
                               codigo.add(nomeDaClasseMinuscula+".set"+primeiraLetramaiscula(aux[1])+"(Integer.valueOf(tf"+primeiraLetramaiscula(aux[1])+".getText()));");
                }else if (aux[0].equals("Date")) {
                               codigo.add(nomeDaClasseMinuscula+".set"+primeiraLetramaiscula(aux[1])+".Format(tf"+primeiraLetramaiscula(aux[1])+".getText()));");
                    
                }else if (aux[0].equals("float")) {
                               codigo.add(nomeDaClasseMinuscula+".set"+primeiraLetramaiscula(aux[1])+"(Float.valueOf(tf"+primeiraLetramaiscula(aux[1])+".getText()));");
                }else{
                    codigo.add(nomeDaClasseMinuscula+".set"+primeiraLetramaiscula(aux[1])+"(tf"+primeiraLetramaiscula(aux[1])+".getText());");
                }
                }
codigo.add(
"                    controle.adicionar("+nomeDaClasseMinuscula+");\n" +
"                    texto.setText(\"Foi adicionado um novo registro\\n\\n\\n\\n\\n\");//limpa o campo texto\n" +
"                }\n" +
"                btSalvar.setVisible(false);\n" +
"                btCancelar.setVisible(false);\n" +
"                btBuscar.setVisible(true);\n" +
"                btListar.setVisible(true);\n");
for (int i = 1; i < atributo.size(); i++) {
                           aux = atributo.get(i).split(";");
                           if (!aux[0].equals("bollean")) {
                            
                            codigo.add("tf"+primeiraLetramaiscula(aux[1])+".setText(\"\");");
                           }
}
aux = atributo.get(0).split(";");
codigo.add("tf"+primeiraLetramaiscula(aux[1])+".requestFocus();\n" +
"                tf"+primeiraLetramaiscula(aux[1])+".selectAll();");
for (int i = 1; i < atributo.size(); i++) {
                           aux = atributo.get(i).split(";");
                           if (aux[0].equals("bollean")) {
                            codigo.add("cb"+primeiraLetramaiscula(aux[1])+".setSelected(false);");
                            codigo.add("cb"+primeiraLetramaiscula(aux[1])+".setEnabled(true);");
                    }else{
                            codigo.add("tf"+primeiraLetramaiscula(aux[1])+".setEditable(false);");
                           }
                }
codigo.add(
"            }\n" +
"\n" +
"        });");
aux = atributo.get(1).split(";");
        codigo.add("btExcluir.addActionListener(new ActionListener() {\n" +
"            @Override\n" +
"            public void actionPerformed(ActionEvent e) {");
        aux = atributo.get(0).split(";");
        codigo.add(
"                tf"+primeiraLetramaiscula(aux[1])+".setText(chavePrimaria);//para retornar ao valor original (caso o usuário mude e tente enganar o programa)\n" +
"                if (JOptionPane.YES_OPTION\n" +
"                        == JOptionPane.showConfirmDialog(null,");
        aux = atributo.get(1).split(";");
        codigo.add(
"                                \"Confirma a exclusão do registro <Nome = \" + "+nomeDaClasseMinuscula+".get"+primeiraLetramaiscula(aux[1])+"() + \">?\", \"Confirm\",\n" +
"                                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {\n" +
"                    controle.excluir("+nomeDaClasseMinuscula+");\n" +
"                }\n" +
"                btBuscar.setVisible(true);\n" +
"                btListar.setVisible(true);");
        aux = atributo.get(0).split(";");
        codigo.add(
"                tf"+primeiraLetramaiscula(aux[1])+".setEditable(true);");
        for (int i = 1; i < atributo.size(); i++) {
                    aux = atributo.get(i).split(";");
                    if (aux[0].equals("bollean")) {
                            codigo.add("cb"+primeiraLetramaiscula(aux[1])+".setSelected(false);");
                            codigo.add("cb"+primeiraLetramaiscula(aux[1])+".setEnabled(true);");
                    }else{
                            codigo.add("tf"+primeiraLetramaiscula(aux[1])+".setText(\"\");");
                           }
        }
        aux = atributo.get(0).split(";");
        codigo.add(
"                tf"+primeiraLetramaiscula(aux[1])+".requestFocus();\n" +
"                tf"+primeiraLetramaiscula(aux[1])+".selectAll();");
        
        codigo.add(
"                btExcluir.setVisible(false);\n" +
"                btAlterar.setVisible(false);\n");
        aux = atributo.get(0).split(";");
        codigo.add(
"                texto.setText(\"Excluiu o registro de \" + "+nomeDaClasseMinuscula+".get"+primeiraLetramaiscula(aux[1])+"() + \"\\n\\n\\n\\n\\n\");//limpa o campo texto\n" +
"            }\n" +
"        });");
        codigo.add("btListar.addActionListener(new ActionListener() {\n" +
"            @Override\n" +
"            public void actionPerformed(ActionEvent e) {\n" +
"                List<"+nomeDaClasse+"> lt = controle.listar();\n");
        //     String [] colunas = {"id","nome","altura","dataNasc"};
                String x = "";
        for (int i = 0; i < atributo.size(); i++) {
            String aux55[] = atributo.get(i).split(";");          
                x +="\""+aux55[1]+"\"" + ",";
        }
        x = x.substring(0, x.length() - 1);
        
        codigo.add("String [] colunas = {"+x+"};\n");

        codigo.add(
"                Object[][] dados = new Object[lt.size()][colunas.length];\n" +
"                String aux[];\n" +
"                for (int i = 0; i < lt.size(); i++) {\n" +
"                    aux = lt.get(i).toString().split(\";\");\n" +
"                    for (int j = 0; j < colunas.length; j++) {\n" +
"                        dados[i][j] = aux[j];\n" +
"                    }\n" +
"                }\n" +
"                cardLayout.show(painelSul, \"Listagem\");\n" +
"                scrollTabela.setPreferredSize(tabela.getPreferredSize());\n" +
"                painel2.add(scrollTabela);\n" +
"                scrollTabela.setViewportView(tabela);\n" +
"                model.setDataVector(dados, colunas);\n" +
"\n" +
"                btAlterar.setVisible(false);\n" +
"                btExcluir.setVisible(false);\n" +
"                btAdicionar.setVisible(false);\n" +
"            }\n" +
"        });");
        codigo.add("\n" +
"        addWindowListener(new WindowAdapter() {\n" +
"            @Override\n" +
"            public void windowClosing(WindowEvent e) {\n" +
"                //antes de sair, salvar a lista em disco\n" +
"                btGravar.doClick();\n" +
"                // Sai da classe\n" +
"                dispose();\n" +
"            }\n" +
"        });\n" +
"\n" +
"        setVisible(true);\n" +
"\n" +
"        //depois que a tela ficou visível, clic o botão automaticamente.\n" +
"        btCarregarDados.doClick();//execute o listener do btCarregarDados");
        codigo.add("}");
        codigo.add("}");
        
        for (int i = 0; i < codigo.size(); i++) {
            System.out.println(codigo.get(i));
        ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
        manipulaArquivo.salvarArquivo("C:\\Users\\nxlok\\OneDrive\\Documentos\\NetBeansProjects\\Cobaia1/src/Main/GUI.java", codigo);
                    }
}
}

